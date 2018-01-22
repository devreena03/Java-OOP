package com.reena.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitLoader {
	
	private Map<String,Person> members;
	private SplitCalculator calculator;
	
	public SplitLoader(List<String> names) {
		calculator = new SplitCalculator();
		members = new HashMap<String, Person>();
		for(String name: names) {
			Person person = new Person(name);
			members.put(name,person);
		}
	}

	public void setExpenditure(String lenderName, List<String> borrowerNames, int amount) {
		Person lender = members.get(lenderName);
		List<Person> borrowers = getPersons(borrowerNames);
		SplitTracker record = new SplitTracker(lender, borrowers, amount);
		calculator.addRecord(record);
	}

	private List<Person> getPersons(List<String> names) {
		List<Person> persons = new ArrayList<>();
		for(String name: names) {
			persons.add(members.get(name));
		}
		return persons;
	}

	public void split() {
		calculator.calculate();
	}

	public void showSatus() {
		for(Person person: members.values()) {
			System.out.println(person.status());
		}
		
	}

}
