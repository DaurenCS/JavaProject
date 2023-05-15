package userPackage;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Vector;

public class Teacher extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private Vector<Course> coursesToTeach;
	private Schedule schedule;

	Teacher(String name, String surname, String id, double salary) {
		super(name, surname, id, salary);
	}

	public Vector<Course> getCoursesToTeach() {
		if (this.coursesToTeach == null) {
			this.coursesToTeach = new Vector<Course>();
		}
		return this.coursesToTeach;
	}

	public void setCoursesToTeach(Vector<Course> coursesToTeach) {
		this.coursesToTeach = coursesToTeach;
	}

	/**
	 * adds course to teach
	 * 
	 * @param c
	 */
	public void addCourseToTeach(Course c) {
		this.getCoursesToTeach().add(c);
	}

	/**
	 * returns schedule
	 * 
	 * @return Schedule
	 */
	public Schedule getSchedule() {
		if (this.schedule == null) {
			this.schedule = new Schedule();
		}
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String toString() {
		return super.toString();
	}

	/**
	 * Gets Info of a Course
	 * 
	 * @param course
	 * @return
	 */
	/// Gets Info of a Course
	public Course getCourseInfo(Course course) {
		if (coursesToTeach.contains(course)) {
			return course;
		}
		return null;
	}

	/**
	 * Gets Student List for a Course as Vector (Uses getStudents() method in
	 * Course)
	 * 
	 * @param course
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	/// Gets Student List for a Course as Vector (Uses getStudents() method in
	/// Course)
	public Vector<Student> getStudentsList(Course course) throws ClassNotFoundException, IOException {
		if (getCourseInfo(course) != null)
			return course.getStudents();
		return new Vector<Student>();
	}

	/**
	 * puts Mark for Student in a Course with default Attendance as PRESENT
	 * 
	 * @param course
	 * @param s
	 * @param mark
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	/// puts Mark for Student in a Course with default Attendance as PRESENT
	public void putMark(Course course, Student s, double mark) throws ClassNotFoundException, IOException {
		if (getStudentsList(course).contains(s)) {
			s.getJournal().getMarks().get(course).add(new JournalLesson(LocalDateTime.now(), Attendance.PRESENT, mark));
		} else {
			System.out.println("You haven't such student");
		}
	}

	/**
	 * puts Attendance for Student in a Course with default mark 0
	 * 
	 * @param course
	 * @param s
	 * @param a
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	/// puts Attendance for Student in a Course with default mark 0
	public void putAttendance(Course course, Student s, Attendance a) throws ClassNotFoundException, IOException {
		if (getStudentsList(course).contains(s)) {
			s.getJournal().getMarks().get(course).add(new JournalLesson(LocalDateTime.now(), a, 0));
		} else {
			System.out.println("You haven't such student");
		}
	}

	/**
	 * Gets Attendance List for Student of a Course as HashMap<LocalDateTime,
	 * Attendance>
	 * 
	 * @param c
	 * @param s
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	/// Gets Attendance List for Student of a Course as HashMap<LocalDateTime,
	/// Attendance>
	public String getAttendanceList(Course c, Student s) throws IOException, ClassNotFoundException {
		String att = "";
		if (getStudentsList(c).contains(s)) {
			HashMap<LocalDateTime, Attendance> m = s.getJournal().getAttendanceList(c);
			for (LocalDateTime t : m.keySet()) {
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String date = t.format(myFormatObj);
				// System.out.println(String.format("%s %s", date, m.get(t)));
				att += String.format("%s     %s\n", date, m.get(t));
			}
		}
		return att;

	}
	/**
	 * Sets attestation for a student 
	 * 1 - first attestation, 2 - second attestation, 3 - final attestation
	 * @param course
	 * @param s
	 * @param mark
	 * @param attestation
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void putAttestation(Course course, Student s, double mark, int attestation)
			throws ClassNotFoundException, IOException {
		if (getStudentsList(course).contains(s)) {
			if (attestation == 1)
				s.getTranscript().getCurCourses().get(course).setFirstAttestation(mark);
			else if (attestation == 2)
				s.getTranscript().getCurCourses().get(course).setSecondAttestation(mark);
			else if (attestation == 3)
				s.getTranscript().getCurCourses().get(course).setFinalAttestation(mark);
			else
				System.out.println(1 / 0);
		}

	}

	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Teacher t = (Teacher) o;
		return this.getSchedule().equals(t.getSchedule()) && this.coursesToTeach.equals(t.getCoursesToTeach());
	}
}