package test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import doors.Door;
import motor.Motor;
import time.MyTimer;

public class DoorTest {
	private static MyTimer timer;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		timer = new MyTimer();
		new Thread(timer).start();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		timer.cancelTimer();
	}

	//test fails if motor does not stop within 5.1 seconds
	@Test(timeout=5000)
	public void testDoor() {
		//create a motor and add to the timer as an observer
		Door door = new Door();
		timer.addObserver(door);
		door.Open();
		while(door.isOpen()) {
			System.out.println("Door is open");
		}
		
		//if test makes it here before 5.1 seconds then test passes
		assertTrue(true);
	}
}
