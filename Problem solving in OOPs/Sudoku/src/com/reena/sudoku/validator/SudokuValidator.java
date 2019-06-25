package com.reena.sudoku.validator;

public abstract class SudokuValidator {
		
	protected int[][] sMatrix;
	protected int matrixSize;
	protected int size;
	
	public SudokuValidator(int size) {
		this.matrixSize = size*size;
		this.size = size;
	}

	public boolean validate(int[][] sMatrix) {	
		this.sMatrix = sMatrix;
		return isValidRows() && isValidColums() && isValidBoxes();
	}
	
	public abstract boolean isValidRows();
	public abstract boolean isValidColums();
	public abstract boolean isValidBoxes();

}
