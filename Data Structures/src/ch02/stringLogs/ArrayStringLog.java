package ch02.stringLogs;

public class ArrayStringLog implements StringLog {

	private String name;
	private String[] logs;
	private int lastIndex;
	private int maxLength = 10;

	public ArrayStringLog(String name) {
		this.name = name;
		reset();
	}

	public ArrayStringLog(String name, int maxLength) {
		this.maxLength = maxLength;
		this.name = name;
		reset();
	}

	@Override
	public void insert(String log) throws StringLogOverflowException {
		if (isFull()) {
			throw new StringLogOverflowException("Log is full");
		}
		lastIndex++;
		logs[lastIndex] = log;
	}

	@Override
	public boolean isFull() {
		return lastIndex == maxLength - 1;
	}

	@Override
	public int size() {
		return lastIndex + 1;
	}

	@Override
	public boolean contains(String element) {
		for (String log : logs) {
			if (log.equalsIgnoreCase(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		reset();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		// Returns the nicely formatted string representing of stringLog
		StringBuilder sb = new StringBuilder("Log: " + name + "\n[ ");

		for (int i = 0; i <= lastIndex; i++) {
			sb.append(logs[i] + ", ");
		}
		if (size() != 0) {
			sb.deleteCharAt(sb.length() - 2);
		}
		sb.append("]");
		return sb.toString();
	}

	private void reset() {
		lastIndex = -1;
		logs = new String[maxLength];
	}

}
