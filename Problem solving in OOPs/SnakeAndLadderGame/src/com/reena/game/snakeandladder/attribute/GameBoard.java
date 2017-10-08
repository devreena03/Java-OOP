package com.reena.game.snakeandladder.attribute;

public class GameBoard {
	
	private static final int NO_OF_CELLS = 30;
	private Snake snake;
	private Ladder ladder;
	
	public GameBoard() {
		this.snake = new Snake();
		this.ladder = new Ladder();
	}

	public void adjustPlayerMovement(Player player) {
		GameBoardMember member = getGameBoardMember(player.getPosition());
		if(null!=member){
			member.changePosition(player);
		}
	}

	public boolean isValidMovement(Player player, int diceValue) {
		return player.getPosition()+diceValue <= NO_OF_CELLS;
	}
	
	private GameBoardMember getGameBoardMember(int position) {
		if(ladder.containsPosition(position)){
			return ladder;
		} 
		if(snake.containsPosition(position)) {
			return snake;
		}
		return null;
	}
	

}
