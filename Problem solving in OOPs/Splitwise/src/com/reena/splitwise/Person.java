package com.reena.splitwise;

public class Person {

	private String name;
	private float balance;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String status() {
		return name+ (balance<0?" gives "+(-balance):" gets "+balance);
	}

	public void adjustBalance(float amountSpent) {
		this.balance += amountSpent;
	}	
}
