package com.reena.splitwise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

	@Test
	public void checkStatus() throws Exception {
		Person reena = new Person("Reena");
		reena.setBalance(200);
		String result = reena.status();
		assertEquals("Reena gets 200", result);
	}
	@Test
	public void checkStatusJaduGets() throws Exception {
		Person jadu = new Person("Jadu");
		jadu.setBalance(300);
		String result = jadu.status();
		assertEquals("Jadu gets 300", result);
	}
	@Test
	public void checkStatusReenaGives() throws Exception {
		Person reena = new Person("Reena");
		reena.setBalance(-200);
		String result = reena.status();
		assertEquals("Reena gives 200", result);
	}
	
}
