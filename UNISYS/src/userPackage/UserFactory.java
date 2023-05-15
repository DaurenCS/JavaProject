package userPackage;

import java.io.IOException;

import viewPackage.AdminMenu;

/**
 * @generated
 */
public class UserFactory {

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @generated
	 * returns User depending on what is the String(student -> Student as class)
	 */
	public User getUser(String type) throws IOException, ClassNotFoundException {
		if (type.equals("student")) {
			String[] info = AdminMenu.inputUserInfo();
			Student toAdd = new Student(info[0], info[1], info[2]);
			AdminMenu.inputSudentInfo(toAdd);
			return toAdd;
		} else if (type.equals("teacher")) {
			String[] info = AdminMenu.inputUserInfo();
			double salary = AdminMenu.inputEmployeeInfo();
			return new Teacher(info[0], info[1], info[2], salary);
		} else if (type.equals("manager")) {
			return new Manager();
		} else if (type.equals("admin")) {
			String[] info = AdminMenu.inputUserInfo();
			double salary = AdminMenu.inputEmployeeInfo();
			return new Admin(info[0], info[1], info[2], salary);
		} else if (type.equals("librarian")) {
			String[] info = AdminMenu.inputUserInfo();
			double salary = AdminMenu.inputEmployeeInfo();
			return new Librarian(info[0], info[1], info[2], salary);
		}
		return null;
	}

}
