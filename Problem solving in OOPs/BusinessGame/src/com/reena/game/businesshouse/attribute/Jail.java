package com.reena.game.businesshouse.attribute;

public class Jail implements GameBoardCell {
	
	private static final int FINE = 150;

	@Override
	public void enter(Player player) {
		player.adjustAmount(-FINE);
	}

}
