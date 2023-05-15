package userPackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;

import mainPackage.Data;
import utilPackage.*;

public class User implements Comparable<User>, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private String id;
	private HashMap<Organization, Status> organizations;
	public boolean isResearcher = false;

	public User() {
		this.name = "test";
		this.surname = "test";
		this.id = "TEST123";
		organizations = new HashMap<Organization, Status>();
		this.isResearcher = false;
	}

	public User(String name, String Surname, String ID) {
		this.name = name;
		this.surname = Surname;
		this.id = ID;
		organizations = new HashMap<Organization, Status>();
		this.isResearcher = false;
	}

	public void makeResearch(Research r) throws ClassNotFoundException, IOException, NotResearcherException {
		if (this.isResearcher == true) {
			Data data = Data.getInstance();
			data.addResearch(r);
		} else {
			throw new NotResearcherException("This is not researcher!");
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String Surname) {
		this.surname = Surname;
	}

	public String getID() {
		return this.id;
	}

	public void setID(String ID) {
		this.id = ID;
	}

	public boolean takeBook() {
		return false;
	}

	public String toString() {
		return this.getClass().getSimpleName() + " || ID: " + this.id + " || " + this.name + " " + this.surname;
	}

	public String simpleToString() {
		return this.getClass().getSimpleName() + " || ID: " + this.id + " || " + this.name + " " + this.surname;
	}

	public Vector<Organization> getOrganizations() {
		return organizations.keySet().stream().collect(Collectors.toCollection(Vector::new));
	}

	public HashMap<Organization, Status> getOrganizationsAndStatus() {
		return organizations;
	}

	public void createOrganization(String name, String description) throws ClassNotFoundException, IOException {
		Organization o = new Organization(name, description);
		Data.getInstance().addOrganization(o);
		this.organizations.put(o, Status.HEAD);
	}

	public void joinOrganization(Organization o) throws ClassNotFoundException, IOException {
		if ((int) o.countMembers() == 0)
			this.organizations.put(o, Status.HEAD);
		else
			this.organizations.put(o, Status.MEMBER);
	}

	public void leaveOrganization(Organization o) {
		this.organizations.remove(o);
	}

	public Vector<News> getNews() throws ClassNotFoundException, IOException {
		return Data.getInstance().getNews();
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
		User user = (User) o;
		return this.name == user.name && this.surname == user.surname && this.id == user.id;
	}

	@Override
	public int compareTo(User o) {
		return this.id.compareTo(o.id);
	}

	public Object Clone() throws CloneNotSupportedException {
		User user = (User) super.clone();
		return user;
	}

}