package motor;

public interface MotorState {
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract boolean isOn();
}
