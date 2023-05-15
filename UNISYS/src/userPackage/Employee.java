package userPackage;

import java.util.Vector;

import utilPackage.*;

public class Employee extends User {

	private static final long serialVersionUID = 1L;
	private double salary;
	private Vector<Message> mailBox = new Vector<Message>();

	Employee() {
	}

	Employee(String name, String surname, String id) {
		super(name, surname, id);
	}

	Employee(String name, String surname, String id, double salary) {
		this(name, surname, id);
		this.salary = salary;
		this.mailBox = new Vector<Message>();
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Vector<Message> getMailBox() {
		return this.mailBox;
	}

	public String toString() {
		return super.toString() + String.format("\n%s || Salary : %s", this.getClass().getSimpleName(), this.salary);
	}
	/**
	 * Sends message to employee
	 * @param e
	 * @param title
	 * @param text
	 */
	public void sendMessage(Employee e, String title, String text) {
		e.getMailBox().add(new Message(title, text, this));
	}

	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Employee e = (Employee) o;
		return this.salary == e.salary && this.mailBox.equals(e.getMailBox());
	}

	public int compareTo(Employee e) {
		if (this.salary < e.salary)
			return 1;
		if (this.salary > e.salary)
			return -1;

		return 0;
	}

}