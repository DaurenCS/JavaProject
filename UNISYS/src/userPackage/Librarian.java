package userPackage;

import java.io.IOException;

import mainPackage.Data;
import utilPackage.Book;

/**
 * @generated
 */
public class Librarian extends Employee implements Cloneable {
	private static final long serialVersionUID = 1L;

	public Librarian() {

	}

	public Librarian(String name, String surname, String id, double salary) {
		super(name, surname, id, salary);
	}

	public boolean equals(Object o) {
		if (super.equals(o) == false) {
			return false;
		}
		return true;
	}
	
	public void addBook(Book b) throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();
		data.addBook(b);
	}

	public void deleteBook(Book b) throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();
		data.deleteBook(b);
	}

	public Object Clone() throws CloneNotSupportedException {
		Librarian librarian = (Librarian) super.clone();
		return librarian;
	}

}
