package elevator;

import java.util.Observable;
import java.util.Observer;

import doors.Door;
import motor.Motor;

public class Elevator implements Observer {
	public volatile Door door;
	volatile ElevatorState elevatorState;
	public volatile Motor motor;
	int floors = 1;
	public Elevator(Door door, Motor motor){
		this.door = door;
		this.motor = motor;
		elevatorState = new ElevatorIdle(this);
	}
	
	public void goingUp(){
			elevatorState.goingUp();
	}
	public void goingDown(){
		elevatorState.goingDown();
	}
	public ElevatorState getElevatorState() {
		return elevatorState;
	}
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	public void increaseFloor(){
		floors++;
	}
	public void decreaseFloor(){
		floors--;
	}
	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
	}
	@Override
	public void update(Observable o, Object arg) {
		elevatorState.checkMotorState();
		// TODO Auto-generated method stub
		
	}
}

