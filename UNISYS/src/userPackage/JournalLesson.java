package userPackage;

import java.io.Serializable;
import java.time.LocalDateTime;

public class JournalLesson implements Serializable {
	private static final long serialVersionUID = 1L;
	private LocalDateTime date;
	private Attendance attendance;
	private double mark;

	public JournalLesson(LocalDateTime date, Attendance att, double mark) {
		this.setDate(date);
		this.setAttendance(att);
		this.setMark(mark);
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}
}
