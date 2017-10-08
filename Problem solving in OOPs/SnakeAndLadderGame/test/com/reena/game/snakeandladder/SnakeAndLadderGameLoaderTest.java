package com.reena.game.snakeandladder;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.reena.game.snakeandladder.SnakeAndLadderGame;
import com.reena.game.snakeandladder.SnakeAndLadderGameLoader;
import com.reena.game.snakeandladder.attribute.Player;

public class SnakeAndLadderGameLoaderTest {

	private SnakeAndLadderGameLoader snakeAndLadderGameLoader;
	
	@Before
	public void init(){
		snakeAndLadderGameLoader = new SnakeAndLadderGameLoader();
	}
	
	@Test
	public void canLoadGameWith2Player() throws Exception {
		SnakeAndLadderGame game = snakeAndLadderGameLoader.loadGame(2);
		List<Player> players = game.getPlayers();
		assertEquals(players.get(0).getName(), "Player-1");
		assertEquals(players.get(1).getName(), "Player-2");
	}
	
	@Test
	public void canLoadGameWith2PlayerWithNames() throws Exception {
		SnakeAndLadderGame game = snakeAndLadderGameLoader.loadGame(Arrays.asList("Reena","Kumari"));
		List<Player> players = game.getPlayers();
		assertEquals(players.get(0).getName(), "Reena");
		assertEquals(players.get(1).getName(), "Kumari");
	}
	
	@Test
	public void canMoveUpWithLadder() throws Exception {
		snakeAndLadderGameLoader.setDiceSequence(Arrays.asList(3,4,6,4,5,6,4,4));
		SnakeAndLadderGame game = snakeAndLadderGameLoader.loadGame(2);
		game.start();
		List<Player> players = game.getPlayers();
		assertEquals(players.get(0).getPosition(), 4);
		assertEquals(players.get(1).getPosition(), 23);
	}
	
	@Test
	public void canComeDownWithSnake() throws Exception {
		snakeAndLadderGameLoader.setDiceSequence(Arrays.asList(4,6,3,6,4,6));
		SnakeAndLadderGame game = snakeAndLadderGameLoader.loadGame(2);
		game.start();
		List<Player> players = game.getPlayers();
		assertEquals(players.get(0).getPosition(), 2);
		assertEquals(players.get(1).getPosition(), 10);
	}
}
