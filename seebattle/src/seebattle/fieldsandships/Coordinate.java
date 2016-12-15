package seebattle.fieldsandships;

public class Coordinate {
	private int y;
	private int x;
	private char marker;

	public Coordinate() {
		this.y = 0;
		this.x = 0;
	}

	public Coordinate(int y, int x) {
		this.y = y;
		this.x = x;
//		marker = 'u';
	}

	public boolean isMarked() {
		return this.marker == 'm';
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

	public void setC(int y, int x) {
		this.x = x;
		this.y = y;
	}

	public boolean hasNextInRow() {
		return (this.getX() + 1) <= 9;
	}

	public Coordinate nextInRow() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(y, x + 1);
	}

	public boolean hasPreviuosInRow() {
		return (this.getX() - 1) >= 0;
	}

	public Coordinate previousInRow() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(y, x - 1);
	}

	public boolean hasNextInColm() {
		return (this.getY() + 1) <= 9;
	}

	public Coordinate nextInColm() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(y + 1, x);
	}

	public boolean hasPreviuosInColm() {
		return (this.getY() - 1) >= 0;
	}

	public Coordinate previousInColm() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(y - 1, x);
	}

	public Coordinate upperCornerLeft() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(y - 1, x - 1);
	}

	public Coordinate lowerCornerLeft() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(y + 1, x - 1);
	}

	public Coordinate upperCornerRight() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(y - 1, x + 1);
	}

	public Coordinate lowerCornerRight() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(y + 1, x + 1);
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
		return marker;
	}

	public void setMarker(char marker) {
		this.marker = marker;
	}
}
