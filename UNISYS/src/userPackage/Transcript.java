package userPackage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;

public class Transcript implements Serializable {

	private static final long serialVersionUID = 1L;
	private int gpa;
	private HashMap<Course, Mark> doneCourses;
	private HashMap<Course, Mark> curCourses;
	private int allCredits;

	public Transcript() {
		doneCourses = new HashMap<Course, Mark>();
		curCourses = new HashMap<Course, Mark>();
	}

	public double getGpa() {
		Vector<Course> c = this.getDoneCourses().keySet().stream().collect(Collectors.toCollection(Vector::new));
		Vector<Mark> m = this.getDoneCourses().values().stream().collect(Collectors.toCollection(Vector::new));
		double sumCreditGpa = 0;
		for (int i = 0; i < doneCourses.size(); i++) {
			sumCreditGpa += c.elementAt(i).getCredits() * m.elementAt(i).getGpa();
		}
		return sumCreditGpa / this.getAllCredits();
	}

	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

	public int getAllCredits() {
		return doneCourses.keySet().stream().mapToInt(i -> i.getCredits()).sum();
	}

	public void setAllCredits(int allCredits) {
		this.allCredits = allCredits;
	}

	/**
	 * returns transcript as String
	 * 
	 * @return String
	 */
	public String getTranscript() {
		String trans = "TRANSCRIPT";
		trans += "\nCurrent courses: \n";
		Vector<Course> c = curCourses.keySet().stream().collect(Collectors.toCollection(Vector::new));
		Vector<Mark> m = curCourses.values().stream().collect(Collectors.toCollection(Vector::new));
		for (int i = 0; i < curCourses.size(); i++) {
			trans += c.elementAt(i).getName() + "   " + m.elementAt(i).getFirstAttestation() + "  "
					+ m.elementAt(i).getSecondAttestation() + "  " + m.elementAt(i).getFinalAttestation() + " || "
					+ m.elementAt(i).getTotalAttestation() + "\n";
		}

		trans += "Finished courses: \n";
		c = doneCourses.keySet().stream().collect(Collectors.toCollection(Vector::new));
		m = doneCourses.values().stream().collect(Collectors.toCollection(Vector::new));
		for (int i = 0; i < doneCourses.size(); i++) {
			trans += c.elementAt(i).getName() + "   " + m.elementAt(i).getFirstAttestation() + "  "
					+ m.elementAt(i).getSecondAttestation() + "  " + m.elementAt(i).getFinalAttestation() + " || "
					+ m.elementAt(i).getTotalAttestation() + " || " + m.elementAt(i).getGpa() + "\n";
		}
		trans += String.format("Total number of Credits: %s  ,  " + "Total GPA : %s", this.getAllCredits(),
				this.getGpa());
		return trans;

	}

	public HashMap<Course, Mark> getDoneCourses() {
		for (Course c : this.getCurCourses().keySet()) {
			if (this.getCurCourses().get(c).getFirstAttestation()
					+ this.getCurCourses().get(c).getSecondAttestation() >= 30
					&& this.getCurCourses().get(c).getFinalAttestation() >= 20) {
				this.doneCourses.put(c, this.getCurCourses().get(c));
				this.curCourses.remove(c);
			}
		}
		return this.doneCourses;

	}

	public void setDoneCourses(HashMap<Course, Mark> doneCourses) {
		this.doneCourses = doneCourses;
	}

	public HashMap<Course, Mark> getCurCourses() {
		if (this.curCourses == null) {
			this.curCourses = new HashMap<Course, Mark>();
		}
		return this.curCourses;
	}

	public void setCurCourses(HashMap<Course, Mark> curCourses) {
		this.curCourses = curCourses;
	}

}