package userPackage;

import java.util.Collections;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

/**
 * @generated
 */
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	private Vector<Lesson> lessonList = new Vector<Lesson>();

	/**
	 * @generated
	 */
	public Vector<Lesson> getLessonList() {
		if (this.lessonList == null) {
			this.lessonList = new Vector<Lesson>();
		}
		return this.lessonList;
	}

	/**
	 * @generated
	 */
	public void setLessonList(Vector<Lesson> lessonList) {
		this.lessonList = lessonList;
	}
	// Operations

	/**
	 * @generated
	 */
	public String toString() {
		String sch = "";
		if (this.lessonList == null) {
			this.lessonList = new Vector<Lesson>();
		}
		Collections.sort(lessonList);
		for (Lesson l : lessonList) {
			sch += l;
			try {
				sch += " " + l.getTeacherForLesson().simpleToString();
			}
			catch(Exception e) {
			
			}
			sch += "\n";
		}
		if (sch.equals("")) {
			sch = "NO SCHEDULE";
		}
		return sch;
	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @generated
	 * adds lesson in the schedule
	 */
	public void addLesson(Lesson l) throws ClassNotFoundException, IOException {
		if (l.getNumberOfStudents() + 1 <= l.getRoom().getNumberOfSeats())
			this.lessonList.add(l);

	}

	/**
	 * @generated
	 * removes lesson from the schedule
	 */
	public void removeLesson(Lesson l) {
		if (this.lessonList.contains(l)) {
			this.lessonList.remove(l);
		}
	}

}
