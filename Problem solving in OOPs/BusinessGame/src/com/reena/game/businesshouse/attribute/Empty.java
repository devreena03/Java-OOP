package com.reena.game.businesshouse.attribute;

public class Empty implements GameBoardCell {

	@Override
	public void enter(Player player) {
		player.adjustAmount(0);
	}

}
