package com.reena.marsrover.directions;

import com.reena.marsrover.Position;

public interface Direction {

	public Direction moveLeft();

	public Direction moveRight();

	public Position moveUp(Position position);

}
