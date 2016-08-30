package seebattle;

import java.util.ArrayList;
import java.util.List;

public class Ship {
	Coordinate c;
	private int motors;
    private List<Coordinate> blocks = new ArrayList<Coordinate>();
//	private ShipState state;
    
    public Ship() {}
	
	public Ship(List<Coordinate> blocks) {
		this.blocks = blocks;
		this.motors = blocks.size();
//		this.state = ShipState.NEW;
	}
	
	public int getMotors() {
		return motors;
	}
	
	public void setMotors(int motors) {
		this.motors = motors;
	}
	
	public void addToBlocks(Coordinate c) {
		blocks.add(c);
	}
//	
//	public void setState(ShipState state) {
//		this.state = state;
//	}

	public List<Coordinate> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Coordinate> blocks) {
		this.blocks = blocks;
	}
	
	public int getSizeOfBlocks() {
		return blocks.size();
	}


	public ShotResult processShot(Coordinate c) {
		if(blocks.contains(c)) {
			blocks.remove(c);

			if(blocks.size() == 0)
				return ShotResult.DEAD;
			else
				return ShotResult.HIT;
		} else {
			return ShotResult.MISS;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blocks == null) ? 0 : blocks.hashCode());
		result = prime * result + motors;
//		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (blocks == null) {
			if (other.blocks != null)
				return false;
		} else if (!blocks.equals(other.blocks))
			return false;
		if (motors != other.motors)
			return false;
//		if (state != other.state)
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ship [motors=" + motors + ", blocks=" + blocks + "]";
	}
}