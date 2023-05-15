package userPackage;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Vector;

public class Journal implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap<Course, Vector<JournalLesson>> marks;

	public Journal() {
		this.marks = new HashMap<Course, Vector<JournalLesson>>();
	}

	public HashMap<Course, Vector<JournalLesson>> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<Course, Vector<JournalLesson>> marks) {
		this.marks = marks;
	}

	public HashMap<LocalDateTime, Attendance> getAttendanceList(Course c) {
		HashMap<LocalDateTime, Attendance> att = new HashMap<LocalDateTime, Attendance>();
		for (JournalLesson jl : marks.get(c)) {
			att.put(jl.getDate(), jl.getAttendance());
		}
		return att;
	}
	/**
	 * returns sum of all marks in journal
	 * @param c
	 * @return double
	 */
	public double getSumMarks(Course c) {
		return marks.get(c).stream().mapToDouble(jl -> jl.getMark()).sum();
	}
	/**
	 * returns number of all PRESENT in journal as integer
	 */
	public int getCountOfPresent(Course c) {
		return (int) getAttendanceList(c).values().stream().filter(i -> i == Attendance.PRESENT).count();
	}
	/**
	 * returns journal info for course as String
	 * @param c
	 * @return String
	 */
	public String getJournalForCourse(Course c) {
		String jfc = c.getName() + "\n";
		for (JournalLesson jl : marks.get(c)) {
			jfc += (String.format("%s || %s || %s", jl.getDate(), jl.getAttendance(), jl.getMark()));
		}
		return jfc;
	}

}