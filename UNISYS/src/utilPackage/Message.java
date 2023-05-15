package utilPackage;

import java.io.Serializable;

import userPackage.Employee;

/**
 * @generated
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	private String title;

	/**
	 * @generated
	 */
	private String text;
	/**
	 * @generated
	 */
	private Employee from;
	private boolean status = false;

	public Message(String title, String text, Employee e) {
		this.title = title;
		this.text = text;
		this.from = e;
		this.status = false;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean s) {
		this.status = s;
	}

	/**
	 * @generated
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @generated
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @generated
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * @generated
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @generated
	 */
	public Employee getFrom() {
		return this.from;
	}

	/**
	 * @generated
	 */
	public void setFrom(Employee from) {
		this.from = from;
	}

	// Operations

	/**
	 * @generated
	 */
	public String toString() {
		return this.title + " || " + this.from.simpleToString();
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
		Message mes = (Message) o;
		return this.title == mes.title && this.text == mes.text;
	}

}
