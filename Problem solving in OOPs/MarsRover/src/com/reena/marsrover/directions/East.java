package com.reena.marsrover.directions;

import com.reena.marsrover.Position;

public class East implements Direction {
	@Override
	public Direction moveLeft() {
		return new North();	
	}

	@Override
	public Direction moveRight() {
		return new South();		
	}
	
	@Override
	public String toString() {
		return "E";
	}

	@Override
	public Position moveUp(Position position) {
		 position.setxCoordinate(position.getxCoordinate()+1);
		 return position;
	}
}
