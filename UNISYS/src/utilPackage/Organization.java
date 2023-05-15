package utilPackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.stream.Collectors;

import mainPackage.Data;
import userPackage.User;

/**
 * @generated
 */
public class Organization implements Serializable, Comparable<Organization> {

	private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	private String name;

	/**
	 * @generated
	 */
	private String description;

	public Organization() {
		name = "TEST ORGANIZATION";
		description = "test";
	}

	public Organization(String name, String description) {
		this.name = name;
		this.description = description;
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

	public User getHead() throws ClassNotFoundException, IOException {
		return Data.getInstance().getUserList().stream()
				.filter(u -> u.getOrganizationsAndStatus().get(this) == Status.HEAD).collect(Collectors.toList())
				.get(0);
	}

	public long countMembers() throws ClassNotFoundException, IOException {
		try {
			return (Data.getInstance().getUserList().stream().filter(u -> u.getOrganizations().contains(this)).count());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
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

	public String toString() {
		return name + "\n" + description;
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
		Organization or = (Organization) o;
		return this.getName().equals(or.getName()) && this.getDescription().equals(or.getDescription());
	}

	public int compareTo(Organization o) {
		try {
			if (this.countMembers() == (o.countMembers()))
				return 0;
			if (this.countMembers() > (o.countMembers()))
				return 1;
			return -1;
		} catch (Exception e) {
			return 0;
		}
	}
}
