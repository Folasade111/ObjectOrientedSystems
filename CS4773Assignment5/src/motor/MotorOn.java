package motor;
public class MotorOn implements MotorState {
	
	private Motor motor;
	
	public MotorOn(Motor motor){
		this.motor = motor;
	}
	
	public void turnOn() {
		System.out.println("Already on");
	}
	
	public void turnOff() {
		System.out.println("Motor turning off");
		motor.setMotorState(new MotorOff(motor));
	}
	
	public boolean isOn() {
		return true;
	}
}
