package seebattle.fieldsandships;

public class Coordinate {
	private int x;
	private int y;
	private char marker;

	public Coordinate() {
		this.x = 0;
		this.y = 0;
	}

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
//		marker = 'u';
	}

	public boolean isMarked() {
		return this.marker == 'm';
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
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

	public char getMarker() {
		return this.marker;
	}

	public void setMarker(char marker) {
		this.marker = marker;
	}
}
