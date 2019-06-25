package com.reena.sudoku.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.reena.sudoku.solver.SudokuSolver;

public class SudokuBuilder {

	private int size;
	private int matrixSize;
	private int[] randomValueArray;
	private SudokuSolver solver;
	private Random rand = new Random();
	
	private static final int EMPTYCELL_3X3 = 50;
	private static final int EMPTYCELL_2X2 = 10;
	private static final int[] RANDOM_VALUE_3X3 = {4,8,3,2,7,9,1,5,6};
	private static final int[] RANDOM_VALUE_2X2 = {1,3,4,2};
	
	private static Map<Integer, Integer> SIZE_LOOKUP= new HashMap<>();
	private static Map<Integer, int[]> VALUE_LOOKUP= new HashMap<>();
	
	static {
		SIZE_LOOKUP.put(2, EMPTYCELL_2X2);
		SIZE_LOOKUP.put(3, EMPTYCELL_3X3);
		
		VALUE_LOOKUP.put(2, RANDOM_VALUE_2X2);
		VALUE_LOOKUP.put(3, RANDOM_VALUE_3X3);
	}

	public SudokuBuilder(int size) {
		this.size = size;
		this.matrixSize = size * size;
		this.randomValueArray = getRandomValueArray();	
	}

	public int[] getRandomValueArray() {
		int[] array = new int[matrixSize];
		for(int i=0 ; i<size ; i++) {
			int index = rand.nextInt(matrixSize);
			array[index] = VALUE_LOOKUP.get(size)[matrixSize - index -1];
			array[matrixSize - index -1] = VALUE_LOOKUP.get(size)[index];
		}
		for(int i=0 ; i<matrixSize ; i++) {
			if(array[i]==0) {
				array[i] = VALUE_LOOKUP.get(size)[i];
			}		
		}
		//printArray(array);
		return array;
	}

	public int[][] buildCompleteSudoku() {
		int[][] sudoku = new int[matrixSize][matrixSize];
		sudoku[0] = this.randomValueArray;
		int rotateIndex = 0;
		for (int row = 1; row < matrixSize; row++) {
			if (row % size != 0) {
				rotateIndex = rotateIndex + size;
			} else {
				rotateIndex++;
			}
			for (int col = 0; col < matrixSize; col++) {
				int index = (col + rotateIndex) % matrixSize;
				sudoku[row][col] = this.randomValueArray[index];
			}
		}
		return sudoku;
	}

	public int[][] constructSudokuPuzzle() {
		int[][] sudoku = buildCompleteSudoku();
		return emptyRandomCells(sudoku);
	}

	private int[][] emptyRandomCells(int[][] sudoku) {
		int count = SIZE_LOOKUP.get(size);
		
		while (count!=0) {
			int row = rand.nextInt(matrixSize);
			int col = rand.nextInt(matrixSize);
			if (sudoku[row][col] != 0) {
				int temp = sudoku[row][col];
				sudoku[row][col] = 0;
				solver = new SudokuSolver(copy(sudoku), size);
				if (!solver.solve()) {
					System.out.println("invalid Row : " + row + " Col: " + col);
					sudoku[row][col] = temp;	
				}
				count --;	
			}
		}
		return sudoku;
	}

	private int[][] copy(int[][] sudoku) {
		int[][] copiedSudoku = new int[matrixSize][matrixSize];
		for (int row = 0; row < matrixSize; row++) {
			for (int col = 0; col < matrixSize; col++) {
				copiedSudoku[row][col] = sudoku[row][col];
			}
		}
		return copiedSudoku;
	}

	public void printSudoku(int[][] sudoku) {
		System.out.println("-----------------------------------");
		for (int row = 0; row < matrixSize; row++) {
			for (int col = 0; col < matrixSize; col++) {
				System.out.print(sudoku[row][col] + " | ");
			}
			System.out.println("\n-----------------------------------");
		}

	}
	
	public void printArray(int[] array) {
		System.out.println("*************************");
		for(int i=0;i<array.length ;i++) {
			System.out.print(array[i] + " | ");
		}
		System.out.println("\n**************************");
	}

}
