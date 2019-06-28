package com.reena.marsrover.commands;

import com.reena.marsrover.directions.Direction;

public class Right implements Command {

	@Override
	public Direction move(Direction direction) {
		return direction.moveRight();
	}

}
