package com.reena.marsrover.directions;

import com.reena.marsrover.Position;

public class East implements Direction {
	@Override
	public Direction moveLeft() {
		return DIRECTION_LOOKUP.get('N');	
	}

	@Override
	public Direction moveRight() {
		return DIRECTION_LOOKUP.get('S');		
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
