package userPackage;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Manager extends Employee implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public Manager() {

	}

	public Manager(String name, String surname, String id) {
		super(name, surname, id);
	}
	/**
	 * returns report as a String
	 * @return String
	 */
	public String writeReport(String s) {
		return "REPORT for" + LocalDateTime.now() + "\n" + s;
	}

	public boolean equals(Object o) {
		if (super.equals(o) == true) {
			return true;
		}
		return false;
	}

	public Object Clone() throws CloneNotSupportedException {
		Manager manager = (Manager) super.clone();
		return manager;
	}

}