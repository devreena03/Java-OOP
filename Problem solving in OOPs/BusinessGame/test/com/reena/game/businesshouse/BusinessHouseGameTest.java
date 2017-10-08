package com.reena.game.businesshouse;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.reena.game.businesshouse.BusinessHouseGame;
import com.reena.game.businesshouse.attribute.Player;


public class BusinessHouseGameTest {
	
	@Test
	public void canPlayTwoPlayer() throws Exception {
		BusinessHouseGame game = new BusinessHouseGame(Arrays.asList("E","E","J","H","E","T","E","J"));
		game.diceEntry(Arrays.asList(4,4,4,6,7,8,5,11,6,8,4,9,2,10));
		game.setPlayers(2);
		game.start();
		List<Player> players = game.getPlayers();
		Assert.assertEquals(players.get(0).finalValue(), "Player-1 has total worth 750");
		Assert.assertEquals(players.get(1).finalValue(), "Player-2 has total worth 1000");
		
	}
	
	@Test
	public void canPlayTwoPlayerWithName() throws Exception {
		BusinessHouseGame game = new BusinessHouseGame(Arrays.asList("E","E","J","H","E","T","E"));
		game.diceEntry(Arrays.asList(4,4,4,6,7,8,5,11,6,8,4,9,2,10,12,4,7,5));
		game.setPlayers(Arrays.asList("Reena","Meena"));
		game.start();
		List<Player> players = game.getPlayers();
		Assert.assertEquals(players.get(0).finalValue(), "Reena has total worth 1200");
		Assert.assertEquals(players.get(1).finalValue(), "Meena has total worth 650");
		
	}
}
