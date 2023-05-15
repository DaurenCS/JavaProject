package utilPackage;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Vector;

/**
 * @generated
 */
public class Building implements Serializable, Comparator<Building> {

	private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	private String address;

	/**
	 * @generated
	 */
	private Vector<Room> rooms = new Vector<Room>();

	/**
	 * @generated
	 */
	private String name;

	/**
	 * @generated
	 */
	public Building() {

	}

	public Building(String name, String adress) {
		this.name = name;
		this.address = adress;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * @generated
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @generated
	 */
	public Vector<Room> getRooms() {
		if (this.rooms == null) {
			this.rooms = new Vector<Room>();
		}
		return this.rooms;
	}

	/**
	 * @generated
	 */
	public void setRooms(Vector<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * @generated
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @generated
	 */
	public void setName(String name) {
		this.name = name;
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
		Building build = (Building) o;
		return this.address == build.address && this.name == build.name;
	}

	@Override
	public int compare(Building o1, Building o2) {
		return o1.name.compareTo(o2.name);
	}
}
