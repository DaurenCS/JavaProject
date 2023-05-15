package utilPackage;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time implements Serializable {

	private static final long serialVersionUID = 1L;
	private int hours;
	private int minutes;
	private DayType day;
	private String now;
	private String date;

	public Time() {
		this.date = this.getNow();
	}

	public Time(int hours, int minutes, DayType day) {
		this.hours = hours;
		this.minutes = minutes;
		this.day = day;
	}

	public int getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return this.minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public DayType getDay() {
		return this.day;
	}

	public void setDay(DayType day) {
		this.day = day;
	}

	public String getNow() {
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		this.now = ft.format(new Date());
		return this.now;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String toString() {
		return "Day: " + this.day + " H: " + this.hours + " M: " + this.minutes;
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
		Time t = (Time) o;
		return this.hours == t.getHours() && this.minutes == t.getMinutes() && this.day == t.getDay();
	}

	public int compareTo(Object o) {
		if (this.equals(o))
			return 0;
		if (DayType.inNum(day) > DayType.inNum(((Time) o).getDay()))
			return -1;
		else if (DayType.inNum(day) < DayType.inNum(((Time) o).getDay()))
			return 1;
		else {
			if (this.hours > ((Time) o).getHours())
				return -1;
			else if (this.hours < ((Time) o).getHours())
				return 1;
			else {
				if (this.minutes > ((Time) o).getMinutes())
					return -1;
				if (this.minutes < ((Time) o).getMinutes())
					return 1;
			}
		}
		return 0;
	}

}