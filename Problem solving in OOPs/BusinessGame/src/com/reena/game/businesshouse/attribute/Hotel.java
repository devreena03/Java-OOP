package com.reena.game.businesshouse.attribute;

public class Hotel implements GameBoardCell {
	
	private static final int HOTEL_WORTH = 200;
	private static final int HOTEL_RENT = 50;
	private Player owner;
	private boolean owned;

	public boolean isOwned(){
		return this.owned;
	}
	
	@Override
	public void enter(Player player){
		if(!this.owned){
			setOwner(player);
		} else {
			payRent(player);
		}
	}
	
	private void setOwner(Player player){
		this.owner = player;
		this.owner.adjustAmount(-HOTEL_WORTH);
		this.owned = true;
	}
	
	
	private void payRent(Player player){
		player.adjustAmount(-HOTEL_RENT);
		this.owner.adjustAmount(HOTEL_RENT);
	}

}
