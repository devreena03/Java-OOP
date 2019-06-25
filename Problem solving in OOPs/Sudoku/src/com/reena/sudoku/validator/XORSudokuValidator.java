package com.reena.sudoku.validator;

import java.util.HashMap;
import java.util.Map;

public class XORSudokuValidator extends SudokuValidator{
	
	private static final int EXPECTED_XOR_3X3 = (1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9);
	
    private static final int EXPECTED_XOR_2X2 = (1 ^ 2 ^ 3 ^ 4);
	
	private static Map<Integer, Integer> SIZE_LOOKUP= new HashMap<>();
	
	static {
		SIZE_LOOKUP.put(3, EXPECTED_XOR_3X3);
		SIZE_LOOKUP.put(2, EXPECTED_XOR_2X2);
	}
	
	public XORSudokuValidator(int size) {
		super(size);
	}

	public boolean isValidRows() {
		for(int row=0; row<matrixSize ;row++) {
			if(rowXOR(row)!=SIZE_LOOKUP.get(this.size)) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidColums() {
		for(int col=0; col<matrixSize ;col++) {
			if(colXOR(col)!=SIZE_LOOKUP.get(this.size)) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidBoxes() {
		for(int row=0; row<matrixSize ;row+=size)
			for(int col=0; col<matrixSize ;col+=size) {
				if(boxXOR(row,col)!=SIZE_LOOKUP.get(this.size)) {
					return false;
				}
			}
		return true;
	}

	public int rowXOR(int row) {
		int xor=0;
		for(int col=0; col<matrixSize ;col++) {
			xor^=sMatrix[row][col];
		}
		return xor;
	}
	
	public int colXOR(int col) {
		int xor=0;
		for(int row=0; row<matrixSize ;row++) {
			xor^=sMatrix[row][col];
		}
		return xor;
	}
	
	public int boxXOR(int startRow, int startCol) {
		int xor = 0;
		for(int i=startRow; i< startRow+size ; i++)
			for(int j=startCol; j< startCol+size ; j++) {
				xor^=sMatrix[i][j];
			}
		return xor;
	}
}
