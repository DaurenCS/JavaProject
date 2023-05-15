package userPackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;
import java.util.stream.Collectors;

import mainPackage.Data;

public class Course implements CanBeAdded, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private int credits;
	private CourseType type;
	private Vector<Course> prerequisite;
	private Vector<Lesson> scheduledLessons;
	/**
	 * returns Vector of Lessons for Course
	 * @return Vector<Lesson>
	 */
	public Vector<Lesson> getScheduledLessons() {
		if (this.scheduledLessons == null) {
			this.scheduledLessons = new Vector<Lesson>();
		}
		return scheduledLessons;
	}

	private String code;

	Course() {

	}
	/**
	 * adds lesson to course
	 * @param l
	 */
	public void addLesson(Lesson l) {
		if (!scheduledLessons.contains(l))
			this.scheduledLessons.add(l);
	}
	/**
	 * removes lesson from course
	 * @param l
	 */
	public void removeLesson(Lesson l) {
		if (scheduledLessons.contains(l))
			this.scheduledLessons.remove(l);
	}

	Course(String name) {
		this.name = name;
		this.description = null;
	}

	Course(String name, String description) {
		this(name);
		this.description = description;
	}

	Course(String name, String description, int credits) {
		this(name, description);
		this.credits = credits;
	}

	Course(String name, String description, int credits, CourseType type) {
		this(name, description, credits);
		this.type = type;
	}

	public Course(String name, String description, int credits, CourseType type, String code) {
		this(name, description, credits, type);
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public CourseType getType() {
		return this.type;
	}

	public void setType(CourseType type) {
		this.type = type;
	}

	public Vector<Course> getPrerequisite() {
		if (this.prerequisite == null) {
			this.prerequisite = new Vector<Course>();
		}
		return this.prerequisite;
	}

	public void setPrerequisite(Vector<Course> prerequisite) {
		this.prerequisite = prerequisite;
	}
	/**
	 * returns vector of all students that have this course in transcript
	 * @return Vector<Student>
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Vector<Student> getStudents() throws ClassNotFoundException, IOException {
		return Data.getInstance().getUserList().stream().filter(u -> u instanceof Student).map(u -> (Student) u)
				.filter(s -> s.getTranscript().getCurCourses().containsKey(this))
				.collect(Collectors.toCollection(Vector::new));
	}
	/**
	 * returns vector of all teachers that can teach this course
	 * @return Vector<Teacher>
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Vector<Teacher> getTeachers() throws ClassNotFoundException, IOException {
		return Data.getInstance().getUserList().stream().filter(u -> u instanceof Teacher).map(u -> (Teacher) u)
				.filter(t -> t.getCoursesToTeach().contains(this)).collect(Collectors.toCollection(Vector::new));
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return String.format("Course name: %s, description: %s, " + "Number of credits: %s, type : %s, code : %s",
				this.name, this.description, this.credits, this.type, this.code);
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o)
			return true;
		if (this.getClass() != o.getClass())
			return false;
		Course c = (Course) o;
		return this.name == c.name && this.description == c.description && this.credits == c.credits
				&& this.type == c.type && this.code == c.code;
	}

	public Object Clone() throws CloneNotSupportedException {
		Course course = (Course) super.clone();
		return course;
	}

}