package com.reena.game.businesshouse.attribute;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {
	
	private List<GameBoardCell> cells;
	private static Map<String, Class<?>> gameBoardMembers;
	
	static {
		gameBoardMembers = new HashMap<>();
		gameBoardMembers.put("E", Empty.class);
		gameBoardMembers.put("J", Jail.class);
		gameBoardMembers.put("T", Treasure.class);
		gameBoardMembers.put("H", Hotel.class);
	}
	
	public GameBoard(List<String> cellEntries) {
		cells = new ArrayList<>();
		for(String entry: cellEntries){
			this.cells.add(getMember(gameBoardMembers.get(entry)));
		}
	}
	
	public GameBoardCell getCell(int position) {
		return this.cells.get(position % cells.size());
	}

	private GameBoardCell getMember(Class<?> clazz) {
		try {
			Constructor<?> ctor = clazz.getConstructor();
			 return (GameBoardCell) ctor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	public List<GameBoardCell> getCells() {
		return cells;
	}

	public void setMembers(List<GameBoardCell> members) {
		this.cells = members;
	}

}
