package com.reena.sudoku.solver;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Ignore;
import org.junit.Test;

import com.reena.sudoku.validator.SudokuValidator;
import com.reena.sudoku.validator.XORSudokuValidator;

public class SudokuSolverTest {
	
	private int[][] puzzle = {
			{9,0,0,1,0,0,0,0,5},
			{0,0,5,0,9,0,2,0,1},
			{8,0,0,0,4,0,0,0,0},
			{0,0,0,0,8,0,0,0,0},
			{0,0,0,7,0,0,0,0,0},
			{0,0,0,0,2,6,0,0,9},
			{2,0,0,3,0,0,0,0,6},
			{0,0,0,2,0,0,9,0,0},
			{0,0,1,9,0,4,5,7,0},
	};
	
	private int[][] puzzle1 = {
			{0,8,5,0,4,0,6,0,0},
			{9,0,7,0,0,5,0,0,0},
			{2,0,0,6,0,0,9,0,0},
			{0,0,0,7,0,0,0,9,0},
			{7,2,0,4,0,6,0,5,1},
			{0,4,0,0,0,2,0,0,0},
			{0,0,8,0,0,4,0,0,9},
			{0,0,0,5,0,0,3,0,8},
			{0,0,3,0,2,0,1,4,0},
	};
	
	private int[][] puzzle2 = {
			{0,2,4,0},
			{1,0,0,3},
			{4,0,0,2},
			{0,1,3,0}
	};
	
	SudokuSolver solver3x3 = new SudokuSolver(3);
	SudokuSolver solver2x2 = new SudokuSolver(2);
	
	@Test @Ignore
	public void solve2X2() throws Exception {
		solver3x3.setSudoku(puzzle2);
		assertTrue(solver2x2.solve());
		SudokuValidator sudokuValidator = new XORSudokuValidator(2);
		assertTrue(sudokuValidator.validate(solver2x2.getSudoku()));
		solver2x2.printSudoku();
	}
	
	@Test 
	public void solve3X3() throws Exception {
		solver3x3.setSudoku(puzzle1);
		assertTrue(solver3x3.solve());
		SudokuValidator sudokuValidator = new XORSudokuValidator(3);
		assertTrue(sudokuValidator.validate(solver3x3.getSudoku()));
		solver3x3.printSudoku();
	}
	
	@Test 
	public void numberValidEntry() throws Exception {
		solver3x3.setSudoku(puzzle);
		Method isValidEntry = SudokuSolver.class.getDeclaredMethod("isValidEntry", int.class, int.class, int.class);
		isValidEntry.setAccessible(true);
		assertTrue((boolean)isValidEntry.invoke(solver3x3, 7, 1, 3));		
	}
	
	@Test 
	public void numberNotValidEntry() throws Exception {
		solver3x3.setSudoku(puzzle);
		Method isValidEntry = SudokuSolver.class.getDeclaredMethod("isValidEntry", int.class, int.class, int.class);
		isValidEntry.setAccessible(true);
		assertFalse((boolean)isValidEntry.invoke(solver3x3, 7, 1, 9));	
	}
	
}
