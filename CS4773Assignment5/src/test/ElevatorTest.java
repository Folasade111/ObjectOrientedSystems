package test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import doors.Door;
import elevator.Elevator;
import elevator.ElevatorIdle;
import motor.Motor;
import time.MyTimer;

public class ElevatorTest {
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
	@Test(timeout=20000)
	public void testDoor() {
		//create a motor and add to the timer as an observer
		Door door = new Door();
		Motor motor = new Motor();
		Elevator elevator = new Elevator(door,motor);
		elevator.motor.addObserver(elevator);
		timer.addObserver(elevator.door);
		timer.addObserver(elevator.motor);
		elevator.goingUp();
		while(!elevator.getElevatorState().getClass().equals(ElevatorIdle.class)) {
			System.out.print("");
		}
		while(elevator.door.isOpen()){
			System.out.print("");
		}
		//if test makes it here before 5.1 seconds then test passes
		assertTrue(true);
	}
}
