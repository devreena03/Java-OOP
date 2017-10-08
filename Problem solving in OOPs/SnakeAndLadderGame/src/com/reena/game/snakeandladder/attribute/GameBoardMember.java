package com.reena.game.snakeandladder.attribute;

public interface GameBoardMember {
	public void changePosition(Player player);
	public boolean containsPosition(int position);
}
