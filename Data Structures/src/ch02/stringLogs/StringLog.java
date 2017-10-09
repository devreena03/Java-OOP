package ch02.stringLogs;

public interface StringLog {

	public void insert(String e)throws StringLogOverflowException;
	
	public boolean isFull();
	
	public int size();
	
	public boolean contains(String element);
	
	public void clear();
	
	public String getName();
	
	public String toString();
}
