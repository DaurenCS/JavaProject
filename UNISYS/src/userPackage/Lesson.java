package userPackage;

import utilPackage.Time;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;
import java.util.stream.Collectors;

import mainPackage.Data;
import utilPackage.Room;

public class Lesson implements Comparable<Lesson>, Serializable {

	private static final long serialVersionUID = 1L;
	private LessonType type;
	private Time startTime;
	private int duration;
	private Room room;

	public Lesson() {
	}

	public Lesson(LessonType type, Time sTime, int duration, Room room) {
		this.type = type;
		this.startTime = sTime;
		this.duration = duration;
		this.room = room;
	}
	/**
	 * returns number of students for this lesson
	 * @return integer
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public int getNumberOfStudents() throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();

		return (int) data.getUserList().stream().filter(u -> u instanceof Student).map(u -> (Student) u)
				.filter(s -> s.getSchedule().getLessonList().contains(this)).count();
	}
	/**
	 * returns a teacher for lesson
	 * @return Teacher
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Teacher getTeacherForLesson() throws ClassNotFoundException, IOException {
		Data data = Data.getInstance();
		try {
			return data.getUserList().stream().filter(u -> u instanceof Teacher).map(u -> (Teacher) u)
					.filter(t -> t.getSchedule().getLessonList().contains(this))
					.collect(Collectors.toCollection(Vector::new)).get(0);
		} catch (Exception e) {
			return null;
		}
	}

	public LessonType getType() {
		return this.type;
	}

	public void setType(LessonType type) {
		this.type = type;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String toString() {
		return "" + this.type + " " + this.room + " (" + this.startTime + ") +" + this.duration + " min ";
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
		Lesson lesson = (Lesson) o;
		return this.startTime.equals(lesson.startTime);
	}

	public int compareTo(Lesson o) {
		if (this.equals(o))
			return 0;
		return this.startTime.compareTo(((Lesson) o).getStartTime());
	}

}