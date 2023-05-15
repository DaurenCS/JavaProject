package userPackage;

import java.io.Serializable;
import java.util.Vector;

/**
 * @generated
 */
public class Faculty implements Serializable, Comparable<Faculty> {

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
	private Vector<Course> courses;

	public Faculty() {

	}

	public Faculty(String name, String description) {
		this.name = name;
		this.description = description;
		this.courses = new Vector<Course>();
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
	 * returns all courses from faculty
	 */
	public Vector<Course> getCourses() {
		if (this.courses == null) {
			this.courses = new Vector<Course>();
		}
		return this.courses;
	}
	/**
	 * adds course to faculty
	 * @param course
	 */
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	/**
	 * removes course from faculty
	 * @param course
	 */
	public void removeCourse(Course course) {
		if (this.courses.contains(course))
			this.courses.remove(course);
	}

	public String toString() {
		return this.name;
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
		Faculty f = (Faculty) o;
		return this.name == f.name;
	}

	@Override
	public int compareTo(Faculty o) {
		return this.name.compareTo(o.name);
	}
}
