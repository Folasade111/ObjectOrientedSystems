package doors;

import java.util.Observable;
import java.util.Observer;

public class Door implements Observer {
	private int time = 0;
	public volatile DoorState doorState;
	public Door(){
		doorState = new DoorClose(this);
	}
	public void Open() {
		doorState.Open();	
	}
	
	public void Close() {
		doorState.Close();
	}
	
	public DoorState getDoorState() {
		return doorState;
	}
	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
	}
	public boolean isOpen(){
		if(doorState.isOpen()){
			return true;
		}
		return false;
	}
	@Override
	public void update(Observable o, Object arg1) {
		if (this.isOpen()){
			time++;
			if(time == 4){
				doorState.Close();
				time = 0;
			}
		}
	}
}
