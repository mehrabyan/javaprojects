package seebattle;

public class Coordinate {
	private int x;
	private int y;

	public Coordinate() {
		this.x = 0;
		this.y = 0;
	}
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setC(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate nextInRow() {	// mybe void ?
		return new Coordinate(x + 1, y);
	}
	
	public Coordinate previousInRow() {	// mybe void ?
		c.x--;
		return c;
	}
	
	public Coordinate nextInColm() {	// mybe void ?
		c.y++;
		return c;
	}
	
	public Coordinate previousInColm() {	// mybe void ?
		return new Coordinate(x, y - 1);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
}
