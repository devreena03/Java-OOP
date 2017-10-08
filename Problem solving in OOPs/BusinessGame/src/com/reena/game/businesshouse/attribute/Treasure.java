package com.reena.game.businesshouse.attribute;

public class Treasure implements GameBoardCell {
	
	private static final int TREASURE_VALUE = 200;

	@Override
	public void enter(Player player) {
		player.adjustAmount(TREASURE_VALUE);
	}

}
