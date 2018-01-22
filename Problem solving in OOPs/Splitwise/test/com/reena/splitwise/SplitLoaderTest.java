package com.reena.splitwise;

import java.util.Arrays;

import org.junit.Test;

public class SplitLoaderTest {
	SplitLoader loader;
	@Test
	public void loadMembers() throws Exception {
		loader = new SplitLoader(Arrays.asList("A","B","C","D"));
		loader.setExpenditure("A", Arrays.asList("C","D"), 500);
		loader.split();
		loader.showSatus();
	}
	@Test
	public void loadPichavaramTrip() throws Exception {
		loader = new SplitLoader(Arrays.asList("Jadu","Reena","Himanshu"));
		loader.setExpenditure("Himanshu", Arrays.asList("Jadu","Reena","Himanshu"), 24);
		loader.setExpenditure("Reena", Arrays.asList("Jadu","Reena","Himanshu"), 20);
		loader.setExpenditure("Himanshu", Arrays.asList("Jadu","Reena","Himanshu"), 300);
		loader.setExpenditure("Reena", Arrays.asList("Jadu","Reena","Himanshu"), 500);
		loader.setExpenditure("Jadu", Arrays.asList("Jadu","Reena","Himanshu"), 505);
		loader.setExpenditure("Himanshu", Arrays.asList("Jadu","Reena","Himanshu"), 500);
		loader.setExpenditure("Reena", Arrays.asList("Jadu","Reena","Himanshu"), 620);
		loader.split();
		loader.showSatus();
	}

}
