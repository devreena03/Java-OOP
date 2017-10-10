package ch02.stringLogs;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayStringLogTest {
	private StringLog logger;
	
	@Test
	public void canCreateAnEmptyLogWithName() throws Exception {
		logger = new ArrayStringLog("Test Logger");
		assertEquals("Test Logger", logger.getName());
		assertEquals(0, logger.size());
		assertEquals("Log: Test Logger\n[ ]", logger.toString());
	}
	
	@Test
	public void canInsertTheValueInLog() throws Exception {
		logger = new ArrayStringLog("Test Logger");
		logger.insert("value 1");
		logger.insert("value 2");
		assertEquals(2, logger.size());
		assertEquals("Log: Test Logger\n[ value 1, value 2 ]", logger.toString());
	}
	
	@Test(expected = StringLogOverflowException.class)
	public void canThrowExceptionWhenLoggerIsFull() throws Exception {
		logger = new ArrayStringLog("Test Logger", 2);
		logger.insert("value 1");
		logger.insert("value 2");
		logger.insert("value 3");
		assertEquals(2, logger.size());
		assertEquals("Log: Test Logger\n[ value 1, value 2 ]", logger.toString());
	}
	
	@Test
	public void canClearTheLog() throws Exception {
		logger = new ArrayStringLog("Test Logger", 2);
		logger.insert("value 1");
		logger.insert("value 2");
		assertEquals(2, logger.size());
		logger.clear();
		assertEquals(0, logger.size());
		assertEquals("Log: Test Logger\n[ ]", logger.toString());
	}
	
}
