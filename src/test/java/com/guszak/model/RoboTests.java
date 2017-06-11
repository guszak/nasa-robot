package com.guszak.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.guszak.model.Robot;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoboTests {

	@Test
	public void testMoveRobot() {
		
		Robot robot = new Robot();
		robot.executeMovements("MMRMMRMM");
		assertEquals("(2, 0, S)", robot.getPosition());
	}
	
	@Test
	public void testSameMovements() {
		
		Robot robot = new Robot();
		robot.executeMovements("MML");
		assertEquals("(0, 2, W)", robot.getPosition());
		
		robot = new Robot();
		robot.executeMovements("MML");
		assertEquals("(0, 2, W)", robot.getPosition());
	}
	
	@Test
	public void testInvalidCommands() {
		
		Robot robot = new Robot();
		robot.executeMovements("AAA");
		assertTrue(robot.getError());	
	}
	
	@Test
	public void testMoveOutOfArea() {
		
		Robot robot = new Robot();
		robot.executeMovements("MMMMMMMMMMMMMMMMMMMMMMMM");
		assertTrue(robot.getError());
	}	
}
