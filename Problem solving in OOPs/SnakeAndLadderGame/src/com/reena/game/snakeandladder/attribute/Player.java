package com.reena.game.snakeandladder.attribute;

public class Player {
	
	private String name;
	private int position;
	
	public Player(String name) {
		this.setName(name);
		this.position = 0;
	}
	
	public int move(int count){
		return this.position += count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public void setPosition(int position){
		this.position =position;
	}

	public String showStatus() {
		return this.name + " moved to position "+this.position;
	}

}
