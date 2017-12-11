package motor;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

import time.MyTimer;

public class MotorOff implements MotorState {
	
	private Motor motor;
	
	public MotorOff(Motor motor) {
		this.motor = motor;
	}
	
	public void turnOn() {
		System.out.println("Motor turning on");
		motor.setMotorState(new MotorOn(motor));
	}
	
	public void turnOff() {
		//do nothing
		System.out.println("Already off");
	}
	
	public boolean isOn() {
		return false;
	}
}
