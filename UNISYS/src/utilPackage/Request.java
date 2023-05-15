package utilPackage;

import java.io.Serializable;

import userPackage.*;

/**
 * @generated
 */
public class Request implements Serializable {

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
	private User from;

	/**
	 * @generated
	 */
	private boolean Status;

	public Request() {

	}

	public Request(String title, String text, User from) {
		this.title = title;
		this.text = text;
		this.from = from;
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
	public User getFrom() {
		return this.from;
	}

	/**
	 * @generated
	 */
	public void setFrom(User from) {
		this.from = from;
	}

	/**
	 * @generated
	 */
	public boolean getStatus() {
		return this.Status;
	}

	/**
	 * @generated
	 */
	public void setStatus(Boolean Status) {
		this.Status = Status;
	}

	public void complete() {
	}

	// Operations

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
		Request req = (Request) o;
		return this.title == req.title && this.text == req.text && this.from == req.from;
	}

}
