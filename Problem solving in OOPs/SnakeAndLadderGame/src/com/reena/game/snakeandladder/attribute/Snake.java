package com.reena.game.snakeandladder.attribute;

import java.util.HashMap;
import java.util.Map;

public class Snake implements GameBoardMember {
	
	private static Map<Integer,Integer> snakesEntry;
	
	static {
		snakesEntry = new HashMap<>();
		snakesEntry.put(11, 2);
		snakesEntry.put(18, 10);
		snakesEntry.put(29, 4);
	}
	
	@Override
	public void changePosition(Player player){
		player.setPosition(snakesEntry.get(player.getPosition()));
	}
	
	@Override
	public boolean containsPosition(int position) {
		return snakesEntry.containsKey(position);
	}

}
