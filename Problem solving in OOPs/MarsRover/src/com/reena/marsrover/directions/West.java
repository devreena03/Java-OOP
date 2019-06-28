package com.reena.marsrover.directions;

import com.reena.marsrover.Position;

public class West implements Direction {

	@Override
	public Direction moveLeft() {
		return DIRECTION_LOOKUP.get('S');	
	}

	@Override
	public Direction moveRight() {
		return DIRECTION_LOOKUP.get('N');		
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
