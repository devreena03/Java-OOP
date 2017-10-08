package com.reena.game.businesshouse;

import static org.junit.Assert.*;

import java.util.Arrays;


import org.junit.Test;

import com.reena.game.businesshouse.attribute.Empty;
import com.reena.game.businesshouse.attribute.GameBoard;
import com.reena.game.businesshouse.attribute.Hotel;

public class GameBoardTest {
	
	@Test
	public void instantiateWithEmpty() throws Exception {
		GameBoard board = new GameBoard(Arrays.asList("E"));
		assertTrue(board.getCells().get(0) instanceof Empty);
	}
	
	@Test
	public void instantiateWithHotelAndEmpty() throws Exception {
		GameBoard board = new GameBoard(Arrays.asList("H","E"));
		assertTrue(board.getCells().get(0) instanceof Hotel);
		assertTrue(board.getCells().get(1) instanceof Empty);
	}

}
