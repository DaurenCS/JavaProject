package mainPackage;

import java.util.Vector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

import userPackage.*;
import utilPackage.*;

/**
 * @generated Main Data class
 */
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * @generated
	 */
	/// INSTANCE of Data
	private static Data instance;

	/**
	 * @generated Vector of all Requests in the system
	 */
	/// Vector of all Requests in the system
	private Vector<Request> allRequests = new Vector<Request>();
	/**
	 * Vector of all News in the system
	 */
	/// Vector of all News in the system
	private Vector<News> news = new Vector<News>();
	/**
	 * Vector of all researches in the system
	 */
	/// Vector of all researches in the system
	private Vector<Research> researches = new Vector<Research>();

	/**
	 * @generated Vector of all books in the systems
	 */
	private Vector<Book> library = new Vector<Book>();
	/**
	 * Vector of all organizations in the system
	 */
	private Vector<Organization> allOrganizations = new Vector<Organization>();
	/**
	 * @generated Vector of all faculties in the system
	 */
	private Vector<Faculty> faculties = new Vector<Faculty>();

	/**
	 * @generated HashMap of LogInfo(login and password) and User
	 */
	private HashMap<LogInfo, User> userList = new HashMap<LogInfo, User>();

	private Data() {

	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @generated Returns INSTANCE of Data (includes serialization)
	 */
	public static Data getInstance() throws ClassNotFoundException, IOException {
		if (instance == null) {
			try {
				FileInputStream fileInputStream = new FileInputStream("data.ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				instance = (Data) objectInputStream.readObject();
				System.out.println("+");
				objectInputStream.close();
			} catch (Exception e) {
				instance = new Data();
				instance.addDefaultData();
			}
		}
		// System.out.println(instance);
		return instance;
	}

	/**
	 * returns Vector of all researches
	 * 
	 * @return
	 */
	public Vector<Research> getResearches() {
		return researches;
	}

	/**
	 * adds new research
	 * 
	 * @param r
	 */
	public void addResearch(Research r) {
		this.researches.add(r);
	}

	/**
	 * adds News in the Vector of News
	 */
	/// adds News in the Vector of News
	public void addNews(News news) {
		if (!this.news.contains(news))
			this.news.add(news);
	}

	/**
	 * remove News from the Vector of News
	 */
	/// remove News from the Vector of News
	public void deleteNews(News news) {
		if (this.news.contains(news))
			this.news.remove(news);
	}

	/**
	 * returns Vector of News
	 */
	/// returns Vector of News
	public Vector<News> getNews() {
		return this.news;
	}

	/**
	 * Changes password of a user
	 */
	/// Changes password of a user
	public void changePassword(User u, String oldP, String newP) {
		LogInfo li = new LogInfo("", "");
		for (Entry<LogInfo, User> entry : userList.entrySet()) {
			if (u.equals(entry.getValue())) {
				li = entry.getKey();
			}
		}
		if (li.getPassword().equals(oldP)) {
			userList.remove(li);
			li.setPassword(newP);
			userList.put(li, u);
		}

	}

	/**
	 * @generated returns Vector of all requests
	 */
	/// returns Vector of all requests
	public Vector<Request> getAllRequests() {
		return this.allRequests;
	}

	/**
	 * adds a request in the system
	 */
	/// adds a request in the system
	public void addRequest(Request r) {
		this.allRequests.add(r);
	}

	/**
	 * @generated 
	 * adds book in the library
	 */
	/// adds book in the library
	public void addBook(Book book) {
		if (!this.library.contains(book))
			this.library.add(book);
	}

	/**
	 * removes book from the library
	 */
	/// removes book from the library
	public void deleteBook(Book book) {
		if (this.library.contains(book))
			this.library.remove(book);
	}

	/**
	 * returns Vector of books
	 */
	/// returns Vector of books
	public Vector<Book> getLibrary() {
		return this.library;
	}

	/**
	 * @generated returns Vector of faculties
	 */
	/// returns Vector of faculties
	public Vector<Faculty> getFaculties() {
		return this.faculties;
	}

	/**
	 * returns Vector of all Courses
	 */
	public Vector<Course> getAllCourses() {
		Vector<Course> all = new Vector<Course>();
		for (Faculty f : this.faculties) {
			for (Course c : f.getCourses()) {
				all.add(c);
			}
		}
		return all;
	}

	/**
	 * @generated adds Faculty in the System
	 */
	public void addFaculty(Faculty faculty) {
		if (!this.faculties.contains(faculty))
			this.faculties.add(faculty);
	}

	/**
	 * removes faculty from the Vector of Faculties
	 */
	public void deleteFaculty(Faculty f) {
		if (this.faculties.contains(f))
			this.faculties.remove(f);
	}

	/**
	 * returns current User of the system
	 * 
	 * @param login
	 * @param password
	 * @return User
	 */
	public User getUser(String login, String password) {
		System.out.println(userList.containsKey(new LogInfo(login, password)));
		return userList.get(new LogInfo(login, password));
	}

	/**
	 * returns Vector of all Users
	 * 
	 * @return Vector<User>
	 */
	public Vector<User> getUserList() {
		return new Vector<User>(userList.values());
	}

	/**
	 * deletes a User from System
	 * 
	 * @param u
	 */
	public void deleteUser(User u) {
		LogInfo li = new LogInfo("", "");
		for (Entry<LogInfo, User> entry : userList.entrySet()) {
			if (u.equals(entry.getValue())) {
				li = entry.getKey();
			}
		}
		userList.remove(li);
	}

	/**
	 * adds User to the System
	 * 
	 * @param u
	 */
	public void addUser(User u) {
		String login = u.getName().toLowerCase().charAt(0) + "_" + u.getSurname().toLowerCase();
		String password = u.getName().toLowerCase().charAt(0) + "_" + u.getSurname().toLowerCase();
		System.out.println(login + "-" + password);
		userList.put(new LogInfo(login, password), u);
	}

	/**
	 * returns Vector of all Organizations
	 * 
	 * @return
	 */
	public Vector<Organization> getAllOrganizations() {
		return this.allOrganizations;
	}

	/**
	 * adds Organization
	 * 
	 * @param o
	 */
	public void addOrganization(Organization o) {
		if (!this.allOrganizations.contains(o))
			this.allOrganizations.add(o);
	}

	/**
	 * deletes Organization
	 * 
	 * @param o
	 */
	public void removeOrganization(Organization o) {
		if (this.allOrganizations.contains(o))
			this.allOrganizations.remove(o);
	}

	/**
	 * Special method that adds default data Includes: Admin -> login: admin ,
	 * password: admin FIT faculty OOP and ADS courses Default News and default
	 * organization
	 */
	public void addDefaultData() {
		userList.put(new LogInfo("admin", "admin"), new Admin());
		Faculty nf = new Faculty("FIT", "Cool af");
		nf.addCourse(new Course("OOP", "Really cool", 3, CourseType.MAJOR, "CSCI2106"));
		nf.addCourse(new Course("ADS", "Really tough", 3, CourseType.MAJOR, "CSCI2105"));
		this.faculties.add(nf);
		this.news.add(new News());
		this.allOrganizations.add(new Organization());
	}
}
