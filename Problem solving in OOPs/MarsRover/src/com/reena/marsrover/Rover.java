package com.reena.marsrover;

import java.util.HashMap;
import java.util.Map;

import com.reena.marsrover.directions.Direction;
import com.reena.marsrover.directions.East;
import com.reena.marsrover.directions.North;
import com.reena.marsrover.directions.South;
import com.reena.marsrover.directions.West;

public class Rover {
	private Position position;
	private Direction direction;
	
	@SuppressWarnings("serial")
	private final static Map<Character, Direction> DIRECTION_LOOKUP = new HashMap<Character, Direction>() {{
		put('N', new North());
		put('S', new South());
		put('E', new East());
		put('W', new West());
		
	}};
	
	public Rover(int x, int y, char dir) {
		position = new Position(x, y);
		direction = DIRECTION_LOOKUP.get(dir);
	}
	
	public void move(char command) {
		if(command == 'L') {
			direction = direction.moveLeft();
		}if(command == 'R') {
			direction = direction.moveRight();
		}if(command == 'M') {
			position = direction.moveUp(position);
		}	
	}

	public void startMoving(String instructions) {
		char[] commands = instructions.toCharArray();
		for (char c : commands) {
			move(c);
		}
	}
	
	public String getCurrentPosition() {
		return position.getxCoordinate()+" "+position.getyCoordinate()+ " "+direction.toString();
	}

}
