package com.reena.game.businesshouse.attribute;

public class Player {
	
	private static final int INITIAL_AMOUNT = 1000;
	private int money;
	private String name;
	private int position;
	
	public Player(String name) {
		this.setName(name);
		this.setMoney(INITIAL_AMOUNT);
		this.position = -1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public String showStatus(){
		return this.name +" has worth left " + this.money;
	}
	
	public String finalValue(){
		return this.name + " has total worth " + this.money;
	}

	public void adjustAmount(int amount) {
		this.money += amount;
	}

	public int getPosition() {
		return position;
	}

	public int move(int position) {
		return this.position += position;
	}

}
