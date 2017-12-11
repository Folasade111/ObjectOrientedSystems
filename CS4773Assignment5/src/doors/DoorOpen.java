package doors;

public class DoorOpen implements DoorState {
	private Door door;
	public DoorOpen(Door door){
		this.door = door;
	}
	@Override
	public void Open() {
		//System.out.println("Door is already Opened");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Close() {
		System.out.println("Doors are closed");
		door.setDoorState(new DoorClose(door));
		// TODO Auto-generated method stub
		
	}
	
	public boolean isOpen(){
		return true;
	}

}
