package elevator;

public class Elevatorgoingup implements ElevatorState {
	private Elevator elevator;

	public Elevatorgoingup(Elevator elevator){
		this.elevator = elevator;
	}
	@Override
	public void goingUp() {
		System.out.println("Elevator is going up");
	}
	@Override
	public void goingDown(){
		System.out.println("Don't wanna go down");
	}
	public void checkMotorState(){
		if(!elevator.motor.isOn()){
			System.out.println("Elevator is idle");
			elevator.increaseFloor();
			System.out.println("Elevator arrived at " +elevator.getFloors());
			elevator.door.Open();
			elevator.setElevatorState(new ElevatorIdle(elevator));	
			
		}
	}
}
