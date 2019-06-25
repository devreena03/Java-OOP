package com.reena.sudoku.builder;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.reena.sudoku.solver.SudokuSolver;
import com.reena.sudoku.validator.SudokuValidator;
import com.reena.sudoku.validator.XORSudokuValidator;

public class SudokuBuilderTest {
	
	SudokuBuilder builder3x3 = new SudokuBuilder(3);
	SudokuBuilder builder2x2 = new SudokuBuilder(2);
	SudokuValidator sudokuValidator3x3 = new XORSudokuValidator(3);
	SudokuValidator sudokuValidator2x2 = new XORSudokuValidator(2);
	
	@Test @Ignore
	public void buildSudoku3X3() throws Exception {
		int[][] sudoku = builder3x3.buildCompleteSudoku();
		builder3x3.printSudoku(sudoku);
		
		assertTrue(sudokuValidator3x3.validate(sudoku));
	}

	@Test @Ignore
	public void buildSudoku2X2() throws Exception {
		int[][] sudoku = builder2x2.buildCompleteSudoku();
		builder2x2.printSudoku(sudoku);
		assertTrue(sudokuValidator2x2.validate(sudoku));
	}
	
	@Test 
	public void buildSudokuPuzzle2X2() throws Exception {
		int[][] sudoku = builder2x2.constructSudokuPuzzle();
		builder2x2.printSudoku(sudoku);
		SudokuSolver solver = new SudokuSolver(sudoku, 2);
		solver.solve();
		builder2x2.printSudoku(sudoku);
		assertTrue(sudokuValidator2x2.validate(sudoku));
	}
	
	@Test 
	public void buildSudokuPuzzle3X3() throws Exception {
		int[][] sudoku = builder3x3.constructSudokuPuzzle();
		builder3x3.printSudoku(sudoku);
		SudokuSolver solver = new SudokuSolver(sudoku, 3);
		solver.solve();
		builder3x3.printSudoku(sudoku);
		assertTrue(sudokuValidator3x3.validate(sudoku));
		
	}

}
