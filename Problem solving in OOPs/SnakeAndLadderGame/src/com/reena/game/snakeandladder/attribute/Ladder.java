package com.reena.game.snakeandladder.attribute;

import java.util.HashMap;
import java.util.Map;

public class Ladder implements GameBoardMember {

private static Map<Integer,Integer> ladderEntry;
	
	static {
		ladderEntry = new HashMap<>();
		ladderEntry.put(3, 14);
		ladderEntry.put(8, 23);
	}
	
	@Override
	public void changePosition(Player player){
		player.setPosition(ladderEntry.get(player.getPosition()));
	}

	@Override
	public boolean containsPosition(int position) {
		return ladderEntry.containsKey(position);
	}

}
