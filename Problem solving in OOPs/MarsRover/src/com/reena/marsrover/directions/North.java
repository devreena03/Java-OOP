package com.reena.marsrover.directions;

import com.reena.marsrover.Position;

public class North implements Direction{

	@Override
	public Direction moveLeft() {
		return DIRECTION_LOOKUP.get('W');	
	}

	@Override
	public Direction moveRight() {
		return DIRECTION_LOOKUP.get('E');		
	}
	
	@Override
	public String toString() {
		return "N";
	}

	@Override
	public Position moveUp(Position position) {
		 position.setyCoordinate(position.getyCoordinate()+1);
		 return position;
	}

}
