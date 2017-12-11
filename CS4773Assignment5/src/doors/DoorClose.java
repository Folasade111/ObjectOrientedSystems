package doors;

public class DoorClose implements DoorState {
	private Door door;
	public DoorClose(Door door){
		this.door = door;
	}
	public  void Open(){
		System.out.println("Doors are open");
		door.setDoorState(new DoorOpen(door));	
	}
	
	public void Close(){
		System.out.println("Door is already Closed");
	}
	
	public boolean isOpen(){
		return false;
	}
}
