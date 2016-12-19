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

	public boolean hasNextInRow() {
		return (this.getX() + 1) <= 9;
	}

	public Coordinate nextInRow() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(x + 1, y);
	}

	public boolean hasPreviuosInRow() {
		return (this.getX() - 1) >= 0;
	}

	public Coordinate previousInRow() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(x - 1, y);
	}

	public boolean hasNextInColm() {
		return (this.getY() + 1) <= 9;
	}

	public Coordinate nextInColm() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(x, y + 1);
	}

	public boolean hasPreviuosInColm() {
		return (this.getY() - 1) >= 0;
	}

	public Coordinate previousInColm() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(x, y - 1);
	}

	public Coordinate upperCornerLeft() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(x - 1, y - 1);
	}

	public Coordinate lowerCornerLeft() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(x - 1, y + 1);
	}

	public Coordinate upperCornerRight() {
		int x = this.getX();
		int y = this.getY();
		return new Coordinate(x + 1, y - 1);
	}

	public Coordinate lowerCornerRight() {
		int x = this.getX();
		int y = this.getY();
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
		return "(" + y + "," + x + ")";
	}

	public char getMarker() {
		return marker;
	}

	public void setMarker(char marker) {
		this.marker = marker;
	}
}
