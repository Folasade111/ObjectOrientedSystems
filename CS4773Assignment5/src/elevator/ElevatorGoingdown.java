package elevator;

import doors.Door;
import doors.DoorOpen;
import motor.Motor;

public class ElevatorGoingdown implements ElevatorState {
	private Elevator elevator;
	Motor motor;
	Door door;
	public ElevatorGoingdown(Elevator elevator){
		this.elevator = elevator;
	}
	@Override
	public void goingUp() {
		//do nothing
	}

	@Override
	public void goingDown(){
		//do nothin
	}
	public void checkMotorState(){
		if(!elevator.motor.isOn()){
			System.out.println("Elevator is idle");
			 elevator.decreaseFloor();
			 System.out.println("Elevator arrived at " +elevator.getFloors());
			 elevator.door.Open();
			elevator.setElevatorState(new ElevatorIdle(elevator));	
		}
	}

}
