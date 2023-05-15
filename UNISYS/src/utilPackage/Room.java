package utilPackage;

import java.io.Serializable;

public class Room implements Serializable, Comparable<Room> {

	private static final long serialVersionUID = 1L;
	private int numberOfSeats;
	private String name;
	private int number;

	public Room() {
		this.numberOfSeats = 100000000;
		this.name = "Online";
		this.number = 0;
	}

	public Room(int numOfS, String name, int number) {
		this.numberOfSeats = numOfS;
		this.name = name;
		this.number = number;
	}

	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String toString() {
		return this.name + " " + this.number;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (this.getClass() != o.getClass()) {
			return false;
		}
		Room r = (Room) o;
		return this.name == r.name && this.number == r.number && this.numberOfSeats == r.numberOfSeats;
	}

	@Override
	public int compareTo(Room o) {
		if (this.numberOfSeats > o.numberOfSeats) {
			return 1;
		}
		if (this.numberOfSeats < o.numberOfSeats) {
			return -1;
		}
		return 0;
	}

}