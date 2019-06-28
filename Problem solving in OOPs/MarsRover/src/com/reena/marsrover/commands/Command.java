package com.reena.marsrover.commands;

import java.util.HashMap;
import java.util.Map;

import com.reena.marsrover.directions.Direction;

public interface Command {
	
	@SuppressWarnings("serial")
	public final static Map<Character, Command> COMMAND_LOOKUP = new HashMap<Character, Command>() {{
		put('L', new Left());
		put('R', new Right());
	}};

	Direction move(Direction direction);

}
