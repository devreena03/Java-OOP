package com.reena.game.businesshouse;

import java.util.ArrayList;
import java.util.List;

import com.reena.game.businesshouse.attribute.Dice;
import com.reena.game.businesshouse.attribute.GameBoard;
import com.reena.game.businesshouse.attribute.GameBoardCell;
import com.reena.game.businesshouse.attribute.Player;

public class BusinessHouseGame {

	private List<Player> players;
	private GameBoard gameBoard;
	private Dice dice;
	private int playCount;

	public BusinessHouseGame(List<String> cellEntries) {
		gameBoard = new GameBoard(cellEntries);
	}

	public void setPlayers(int playerCount) {
		players = new ArrayList<Player>();
		for (int count = 1; count <= playerCount; count++) {
			players.add(new Player("Player-" + count));
		}
		this.playCount = 0;
	}

	public void setPlayers(List<String> playerNames) {
		players = new ArrayList<Player>();
		for (int index = 0; index < playerNames.size(); index++) {
			players.add(new Player(playerNames.get(index)));
		}
		this.playCount = 0;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void diceEntry(List<Integer> entries) {
		this.dice = new Dice(entries);
	}

	public void start() {
		for (Integer diceEntry : this.dice.getEntries()) {
			Player player = nextPlayer();
			int position = player.move(diceEntry);
			GameBoardCell cell = gameBoard.getCell(position);
			cell.enter(player);
			System.out.println(player.showStatus());
		}
	}

	private Player nextPlayer() {
		Player player = players.get(this.playCount % players.size());
		this.playCount++;
		return player;
	}

}
