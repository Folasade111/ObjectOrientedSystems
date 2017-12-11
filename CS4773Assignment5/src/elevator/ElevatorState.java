package elevator;

public interface ElevatorState {
	public abstract void goingUp();
	public abstract void goingDown();
	public abstract void checkMotorState();
}
