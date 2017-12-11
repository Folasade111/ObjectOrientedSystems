package elevator;

import doors.Door;
import doors.DoorClose;
import doors.DoorOpen;
import motor.Motor;

public class ElevatorIdle implements ElevatorState {
	private Elevator elevator;
	Door door = new Door();
	Motor motor = new Motor();
	public ElevatorIdle(Elevator elevator){
	this.elevator = elevator;
	}
	@Override
	public void goingUp() {
		if( !elevator.motor.isOn() && !elevator.door.isOpen() && elevator.getFloors() < 5){
			elevator.motor.turnOn();
			System.out.println("Elevator is going up");
			elevator.setElevatorState(new Elevatorgoingup(elevator));
		}
	}

	@Override
	public void goingDown() {
		if(!elevator.motor.isOn() && !elevator.door.isOpen() && elevator.getFloors() > 1){
			elevator.motor.turnOn();
			System.out.println("Elevator is going down");
		elevator.setElevatorState(new ElevatorGoingdown(elevator));
		}
	}
	@Override
	public void checkMotorState() {
		// TODO Auto-generated method stub
		
	}

}
