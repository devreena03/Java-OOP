package com.reena.splitwise;

import java.util.ArrayList;
import java.util.List;

public class SplitCalculator {
	
	List<SplitTracker> records;
	
	public SplitCalculator() {
		records = new ArrayList<>();
	}

	public void addRecord(SplitTracker record) {
		records.add(record);
	}

	public void calculate() {
		for(SplitTracker record: records) {
			float amountSpent = record.getAmountSpent();
			List<Person> borrowers = record.getBorrower();
			record.getLender().adjustBalance(amountSpent);
			adjustBorrowersAmount(amountSpent, borrowers);
		}
	}

	private void adjustBorrowersAmount(float amountSpent, List<Person> borrowers) {
		for(Person borrower: borrowers) {
			borrower.adjustBalance(-amountSpent/borrowers.size());
		}
	}
}
