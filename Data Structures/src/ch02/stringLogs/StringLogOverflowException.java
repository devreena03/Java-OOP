package ch02.stringLogs;

public class StringLogOverflowException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public StringLogOverflowException(){
		super();
	}

	public StringLogOverflowException(String msg){
		super(msg);
	}
}
