package com.reena.game.snakeandladder;

import java.util.List;

import com.reena.game.snakeandladder.attribute.Dice;
import com.reena.game.snakeandladder.attribute.GameBoard;
import com.reena.game.snakeandladder.attribute.Player;

public class SnakeAndLadderGame {
	
	private List<Player> players;
	private Dice dice;
	private GameBoard gameBoard;
	private int playerCount;
	
	public void setPlayers(List<Player> players) {
		this.players = players;
		this.playerCount = -1;
	}
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public void start(){
		while(dice.hasEntry()) {
			play(dice.getNextValue());
		}
	}
	private void play(int diceValue) {
		Player player = nextPlayer();
		if(gameBoard.isValidMovement(player, diceValue)){
			 move(diceValue, player);
		} else {
			System.out.println(player.getName() + " can't move to next position, try next time");
		}
	}
	
	private void move(int diceValue, Player player) {
		 player.move(diceValue);
		 gameBoard.adjustPlayerMovement(player);
		 System.out.println(player.showStatus());
	}
	
	private Player nextPlayer() {
		this.playerCount++;
		return players.get(this.playerCount % players.size());
	}
	public List<Player> getPlayers() {
		return this.players;
	}
	
}
