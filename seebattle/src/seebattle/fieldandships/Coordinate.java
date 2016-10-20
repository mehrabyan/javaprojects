package seebattle.fieldandships;

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

	// can coordinate tell as about his environment ?

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

	public Coordinate nextInRow() {
		return new Coordinate(x + 1, y);
	}

	public Coordinate previousInRow() {
		return new Coordinate(x - 1, y);
	}

	public Coordinate nextInColm() {
		return new Coordinate(x, y + 1);
	}

	public Coordinate previousInColm() {
		return new Coordinate(x, y - 1);
	}

	public Coordinate upperCornerLeft() {
		return new Coordinate(x - 1, y - 1);
	}

	public Coordinate lowerCornerLeft() {
		return new Coordinate(x - 1, y + 1);
	}

	public Coordinate upperCornerRight() {
		return new Coordinate(x + 1, y - 1);
	}

	public Coordinate lowerCornerRight() {
		return new Coordinate(x + 1, y + 1);
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
		return "(" + x + "," + y + ")";
	}
}
