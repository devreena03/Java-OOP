package com.reena.sudoku.validator;

import java.util.HashMap;
import java.util.Map;

public class SumSudokuValidator extends SudokuValidator{
	
	private static final int EXPECTED_SUM_3X3 = 45;
	private static final int EXPECTED_SUM_2X2 = 10;
	
	private static Map<Integer, Integer> SIZE_LOOKUP= new HashMap<>();
	
	static {
		SIZE_LOOKUP.put(2, EXPECTED_SUM_2X2);
		SIZE_LOOKUP.put(3, EXPECTED_SUM_3X3);
	}
	
	public SumSudokuValidator(int boxSize) {
		super(boxSize);
	}
	
	public int rowSum(int row) {
		int sum=0;
		for(int col=0; col<matrixSize ;col++) {
			sum+=sMatrix[row][col];
		}
		return sum;
	}
	
	public int colSum(int col) {
		int sum=0;
		for(int row=0; row<matrixSize ;row++) {
			sum+=sMatrix[row][col];
		}
		return sum;
	}
	
	public int boxSum(int startRow, int startCol) {
		System.out.println("box index: " + startRow + " "+ startCol);
		int sum = 0;
		for(int i=startRow; i< startRow+size ; i++)
			for(int j=startCol; j< startCol+size ; j++) {
				sum+=sMatrix[i][j];
			}
		return sum;
	}
	
	public boolean isValidRows() {
		for(int row=0; row<matrixSize ;row++) {
			if(rowSum(row)!=SIZE_LOOKUP.get(this.size)) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidColums() {
		for(int col=0; col<matrixSize ;col++) {
			if(colSum(col)!=SIZE_LOOKUP.get(this.size)) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidBoxes() {
		for(int row=0; row<matrixSize ;row+=size)
			for(int col=0; col<matrixSize ;col+=size) {
				if(boxSum(row,col)!=SIZE_LOOKUP.get(this.size)) {
					return false;
				}
			}
		return true;
	}
}
