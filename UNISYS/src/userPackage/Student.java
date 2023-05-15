package userPackage;

import java.io.IOException;
import java.util.Vector;

import mainPackage.Data;
import utilPackage.*;

public class Student extends User implements Cloneable, CanBeAdded {

	private static final long serialVersionUID = 1L;
	private Schedule schedule;
	private StudentType type;
	private int yearOfStudy;
	private Faculty faculty;
	private double GPA;

	private int creditLimit;

	private Transcript transcript;
	private Journal journal = new Journal();

	public Student(String name, String surname, String id) {
		super(name, surname, id);
		this.creditLimit = 21;
		this.transcript = new Transcript();
		this.journal = new Journal();
		this.schedule = new Schedule();
	}

	public Student() {

	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public StudentType getType() {
		return this.type;
	}

	public void setType(StudentType type) {
		this.type = type;
	}

	public int getYearOfStudy() {
		return this.yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public double getGPA() {
		return this.GPA;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public int getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(int creLim) {
		this.creditLimit = creLim;
	}

	public Transcript getTranscript() {
		return this.transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	/**
	 * sends request to manager to add course
	 * @param c
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void addCourse(Course c) throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();
		data.getAllRequests().add(new RequestToAdd(c, this.getTranscript().getCurCourses(), this.getID()));
	}
	/**
	 * sends request to manager to drop course
	 * @param c
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void dropCourse(Course c) throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();
		data.getAllRequests().add(new RequestToDelete(c, this.getTranscript().getCurCourses(), this.getID()));
	}

	public String toString() {
		return super.toString() + "\n" + this.type + "  Year: " + this.yearOfStudy + "  Faculty: " + this.faculty
				+ " || GPA: " + this.GPA;
	}

	public boolean equals(Object o) {
		if (super.equals(o) == false) {
			return false;
		}
		return true;
	}

	public Object clone() throws CloneNotSupportedException {
		Student st = (Student) super.clone();
		return st;

	}
	/**
	 * returns journal
	 * @return
	 */
	public Journal getJournal() {
		if (!this.journal.getMarks().keySet().equals(this.transcript.getCurCourses().keySet())) {
			for (Course c : this.transcript.getCurCourses().keySet()) {
				if (!this.journal.getMarks().keySet().contains(c))
					this.journal.getMarks().put(c, new Vector<JournalLesson>());
			}
		}

		return journal;

	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

//    d_kozhakhmetov
}