package com.reena.sudoku.solver;

public class SudokuSolver {

	private int[][] sudoku;
	private int matrixSize;
	private int boxSize;

	public SudokuSolver(int[][] sudoku, int size) {
		this.setSudoku(sudoku);
		this.boxSize = size;
		this.matrixSize = size * size;
	}
	
	public SudokuSolver(int size) {
		this.boxSize = size;
		this.matrixSize = size * size;
	}
	
	public void setSudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}
	
	public int[][] getSudoku(){
		return this.sudoku;
	}
	
	public boolean solve() {
		for (int row = 0; row < matrixSize; row++) {
	         for (int col = 0; col < matrixSize; col++) {	 
	        	 if(getSudoku()[row][col]==0) {
	        		return keepTrackForEachEmptyCell(row, col);
	        	 }  		 
	         }
		}
		return true;
	}

	private boolean keepTrackForEachEmptyCell(int row, int col) {
		for(int number = 1; number<=matrixSize ; number++) {
			if(isValidEntry(row, col, number)) {
				getSudoku()[row][col] = number;
				if(solve()) {
					return true;
				}
				getSudoku()[row][col] = 0;
			}
		}
		return false;
	}

	public void printSudoku() {
		System.out.println("-----------------------------------");
		for (int row = 0; row < matrixSize; row++) {
			for (int col = 0; col < matrixSize; col++) {
				System.out.print(getSudoku()[row][col]+" | ");
			}
			System.out.println("\n-----------------------------------");
		}
		
	}
	
	private boolean isValidEntry(int row, int col, int number) {
		return !isNumberInRow(row, number) && !isNumberInCol(col, number) && !isNumberInBox(row, col, number);
	}

	private boolean isNumberInRow(int row, int no) {
		for (int col = 0; col < matrixSize; col++) {
			if (getSudoku()[row][col] == no)
				return true;
		}
		return false;
	}

	private boolean isNumberInCol(int col, int no) {
		for (int row = 0; row < matrixSize; row++) {
			if (getSudoku()[row][col] == no)
				return true;
		}
		return false;
	}

	private boolean isNumberInBox(int row, int col, int no) {
		int rowStartIndex = row - row % boxSize;
		int colStartIndex = col - col % boxSize;
		for (int i = rowStartIndex; i < rowStartIndex + boxSize; i++)
			for (int j = colStartIndex; j < colStartIndex + boxSize; j++) {
				if (getSudoku()[i][j] == no)
					return true;
			}
		return false;
	}

}
