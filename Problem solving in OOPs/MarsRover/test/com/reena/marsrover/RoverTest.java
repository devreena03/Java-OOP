package com.reena.marsrover;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoverTest {
	
	@Test
	public void roverPosition12N() throws Exception {
		Rover rover = new Rover(1,2,'N');
		assertEquals("1 2 N", rover.getCurrentPosition());
	}
	
	@Test
	public void roverMoveL() throws Exception {
		Rover rover = new Rover(1,2,'N');
		rover.move('L');
		assertEquals("1 2 W", rover.getCurrentPosition());
	}
	
	@Test
	public void roverMoveM() throws Exception {
		Rover rover = new Rover(1,2,'N');
		rover.move('M');
		assertEquals("1 3 N", rover.getCurrentPosition());
	}
	
	@Test
	public void roverFollowCommand1() throws Exception {
		Rover rover = new Rover(1,2,'N');
		rover.startMoving("LMLMLMLMM");
		assertEquals("1 3 N", rover.getCurrentPosition());
	}
	
	@Test
	public void roverFollowCommand2() throws Exception {
		Rover rover = new Rover(3,3,'E');
		rover.startMoving("MMRMMRMRRM");
		assertEquals("5 1 E", rover.getCurrentPosition());
	}

}
