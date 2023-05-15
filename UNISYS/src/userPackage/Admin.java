package userPackage;

import java.io.IOException;
import java.io.Serializable;

import mainPackage.Data;

/**
 * @generated
 */
public class Admin extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * @generated
	 */
	private static UserFactory userFactory = new UserFactory();

	public Admin() {

	}

	public Admin(String name, String surname, String ID, double salary) {
		super(name, surname, ID, salary);
	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @generated
	 * adds user to system
	 */
	public static void addUser(String type) throws ClassNotFoundException, IOException {
		User u = userFactory.getUser(type);
		Data data = Data.getInstance();
		data.addUser(u);
	}
	/**
	 * makes from user a researcher
	 * @param researcher
	 */
	public void makeResearcher(User researcher) {
		researcher.isResearcher = true;
	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @generated
	 * deletes user from UserList in Data
	 */
	public static void deleteUser(User u) throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();
		data.deleteUser(u);
	}
	/**
	 * Adds faculty
	 * @param f
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void addFaculty(Faculty f) throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();
		data.addFaculty(f);
	}
	/**
	 * deletes faculty
	 * @param f
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void deleteFaculty(Faculty f) throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();
		data.deleteFaculty(f);
	}
	/**
	 * Adds course to faculty 
	 * @param f
	 * @param c
	 */
	public void addCourse(Faculty f, Course c) {
		f.addCourse(c);
	}
	
	public boolean equals(Object o) {
		if (super.equals(o) == false) {
			return false;
		}
		return true;
	}

}
