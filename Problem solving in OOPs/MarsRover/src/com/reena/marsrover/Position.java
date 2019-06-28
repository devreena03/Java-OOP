package com.reena.marsrover;

public class Position {
	private int xCoordinate;
	private int yCoordinate;
	
	public Position(int xCoordinate, int yCoordinate) {
		this.setxCoordinate(xCoordinate);
		this.setyCoordinate(yCoordinate);
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
}
