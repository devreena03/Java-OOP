package com.reena.game.snakeandladder;

import java.util.ArrayList;
import java.util.List;

import com.reena.game.snakeandladder.attribute.Dice;
import com.reena.game.snakeandladder.attribute.GameBoard;
import com.reena.game.snakeandladder.attribute.Player;

public class SnakeAndLadderGameLoader {
	
	private SnakeAndLadderGame game;
	private List<Integer> diceSequence;
	
	public SnakeAndLadderGame loadGame(int playerCount){
		this.game  = new SnakeAndLadderGame();
		this.game.setPlayers(initializePlayers(playerCount));
		this.game.setGameBoard(new GameBoard());
		this.game.setDice(new Dice(diceSequence));
		return this.game;
	}
	
	public SnakeAndLadderGame loadGame(List<String> playerNames){
		this.game  = new SnakeAndLadderGame();
		this.game.setPlayers(initializePlayers(playerNames));
		this.game.setGameBoard(new GameBoard());
		this.game.setDice(new Dice(diceSequence));
		return this.game;
	}

	private List<Player> initializePlayers(int playerCount) {
		List<Player> players = new ArrayList<Player>();
		for (int count = 1; count <= playerCount; count++) {
			players.add(new Player("Player-" + count));
		}
		return players;
	}
	
	private List<Player> initializePlayers(List<String> playerNames) {
		List<Player> players = new ArrayList<Player>();
		for (int index = 0; index < playerNames.size(); index++) {
			players.add(new Player(playerNames.get(index)));
		}
		return players;
	}

	public void setDiceSequence(List<Integer> diceSequence) {
		this.diceSequence = diceSequence;
	}

}
