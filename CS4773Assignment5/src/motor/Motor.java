package motor;

import java.util.Observable;
import java.util.Observer;

import time.MyTimer;

public class Motor extends Observable implements Observer {
	
	private  volatile MotorState motorState;
	private int timerCount = 0;
	
	public Motor() {
		motorState = new MotorOff(this);
		
	}
	
	public void turnOn() {
		motorState.turnOn();
	}
	
	public void turnOff() {
		motorState.turnOff();
	}
	
	public MotorState getMotorState() {
		return motorState;
	}
	
	public boolean isOn() {
		if(motorState.isOn()) {
			return true;
		}
		return false;
	}
	
	public void setMotorState(MotorState motorState) {
		this.motorState = motorState;
	}
	
	@Override
	public void update(Observable o, Object arg1) {
		// TODO Auto-generated method stub
		timerCount++;
		if(timerCount == 10) {
			motorState.turnOff();
			timerCount = 0;
			this.setChanged();
			this.notifyObservers();
		}
	}
}
