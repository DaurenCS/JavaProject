package utilPackage;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @generated
 */
public class Book implements Serializable, Comparator<Book> {

	private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	private String name;

	/**
	 * @generated
	 */
	private String description;

	/**
	 * @generated
	 */
	private String text;

	/**
	 * @generated
	 */

	private String author;

	public Book() {

	}

	public Book(String name, String author, String description, String text) {
		this.name = name;
		this.author = author;
		this.description = description;
		this.text = text;
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

	/**
	 * @generated
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @generated
	 */
	public void setDescription(String description) {
		this.description = description;
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

	public String toString() {
		return "Name of book: " + this.name + "|| Author: " + this.author + "\nDescription: " + this.description;
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
		Book book = (Book) o;
		return this.name == book.name && this.author == book.author;
	}

	@Override
	public int compare(Book o1, Book o2) {
		return o1.name.compareTo(o2.name);
	}
}
