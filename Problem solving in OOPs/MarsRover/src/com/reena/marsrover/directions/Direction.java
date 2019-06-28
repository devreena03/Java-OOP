package com.reena.marsrover.directions;

import java.util.HashMap;
import java.util.Map;

import com.reena.marsrover.Position;

public interface Direction {
	
	@SuppressWarnings("serial")
	public final static Map<Character, Direction> DIRECTION_LOOKUP = new HashMap<Character, Direction>() {{
		put('N', new North());
		put('S', new South());
		put('E', new East());
		put('W', new West());
		
	}};

	public Direction moveLeft();

	public Direction moveRight();

	public Position moveUp(Position position);

}
