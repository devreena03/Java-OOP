package com.reena.splitwise;

import java.util.List;

public class SplitTracker {

	private Person lender;
	private List<Person> borrower;
	private float amountSpent;
	
	public SplitTracker(Person lender, List<Person> borrower, int amountSpent ) {
		this.lender = lender;
		this.borrower = borrower;
		this.amountSpent = amountSpent;
	}
	public Person getLender() {
		return lender;
	}
	public void setLender(Person lender) {
		this.lender = lender;
	}
	public List<Person> getBorrower() {
		return borrower;
	}
	public void setBorrower(List<Person> borrower) {
		this.borrower = borrower;
	}
	public float getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}
}
