package mainPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import userPackage.*;
import viewPackage.*;

/**
 * @generated
 * Main class that runs the code
 */
public class UniSystem {
	/**
	 * @generated
	 * Instance of Data class
	 */
	static Data data;

	/**
	 * @generated
	 * current User
	 */
	static User user = null;

	/**
	 * @generated
	 * Menu for current User
	 */
	static Menu menu = new Menu();

	/**
	 * @generated
	 * method for getting menu depending on user
	 */
	private static Menu getMenu(User user) {
		if (user instanceof Student) {
			return new StudentMenu();
		}
		if (user instanceof Teacher) {
			return new TeacherMenu();
		}
		if (user instanceof Manager) {
			return new ManagerMenu();
		}
		if (user instanceof Admin) {
			return new AdminMenu();
		}
		if (user instanceof Librarian) {
			return new LibrarianMenu();
		}
		return new Menu();
	}
	/**
	 * returns currents User
	 * @return User
	 */
	public static User getUser() {
		return user;
	}
	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		data = Data.getInstance();

		while (true) {
			int inp = menu.uniStart();
			if (inp == 1) {
				String login = menu.getLogin();
				String password = menu.getPassword();
				user = data.getUser(login, password);
				if (user == null) {

				}
				// System.out.println(user + login + password);
				menu = getMenu(user);
				menu.show();
			}
			if (inp == 2) {
				System.out.println("S͛hͪuͧᴛⷮᴛⷮiͥng dͩoͦwn...");

				FileOutputStream outputStream = new FileOutputStream("data.ser");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

				objectOutputStream.writeObject(data);

				objectOutputStream.close();
				break;
			}

		}

	}

}
