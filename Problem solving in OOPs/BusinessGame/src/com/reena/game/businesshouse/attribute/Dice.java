package com.reena.game.businesshouse.attribute;

import java.util.List;

public class Dice {
	
	private List<Integer> entries;
	private int currentPosition;
	
	public Dice(List<Integer> entries) {
		this.setEntries(entries);
		this.setCurrentPosition(0);
	}
	
	public Integer getNextValue(){
		return this.getEntries().get(getCurrentPosition());
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public List<Integer> getEntries() {
		return entries;
	}

	public void setEntries(List<Integer> entries) {
		this.entries = entries;
	}

}
