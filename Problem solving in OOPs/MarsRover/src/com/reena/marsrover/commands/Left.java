package com.reena.marsrover.commands;

import com.reena.marsrover.directions.Direction;

public class Left implements Command {

	@Override
	public Direction move(Direction direction) {
		return direction.moveLeft();
	}

}
