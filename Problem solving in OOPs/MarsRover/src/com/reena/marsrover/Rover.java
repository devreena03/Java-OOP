package com.reena.marsrover;

import com.reena.marsrover.commands.Command;
import com.reena.marsrover.directions.Direction;

public class Rover {
	private Position position;
	private Direction direction;
	
	public Rover(int x, int y, char dir) {
		position = new Position(x, y);
		direction = Direction.DIRECTION_LOOKUP.get(dir);
	}
	
	public void move(char command) {
		if(command == 'M') {
			position = direction.moveUp(position);
		} else {
			direction = Command.COMMAND_LOOKUP.get(command).move(direction);
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
