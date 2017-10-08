package com.reena.game.snakeandladder.attribute;

import java.util.ArrayList;
import java.util.List;

public class Dice {
	
	private List<Integer> diceSequence;
	private int currentIndex = -1;

	public Dice(List<Integer> diceSequence) {
		if(null == diceSequence){
			diceSequence = new ArrayList<>();
		} 
		this.diceSequence = diceSequence;
	}

	public int getNextValue() {
		this.currentIndex++;
		return diceSequence.get(currentIndex);
	}

	public boolean hasEntry() {
		return currentIndex < diceSequence.size()-1;
	}

}
