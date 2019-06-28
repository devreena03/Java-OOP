package com.reena.marsrover.directions;

import com.reena.marsrover.Position;

public class West implements Direction {

	@Override
	public Direction moveLeft() {
		return new South();	
	}

	@Override
	public Direction moveRight() {
		return new North();		
	}
	
	@Override
	public String toString() {
		return "W";
	}

	@Override
	public Position moveUp(Position position) {
		 position.setxCoordinate(position.getxCoordinate()-1);
		 return position;
	}

}
