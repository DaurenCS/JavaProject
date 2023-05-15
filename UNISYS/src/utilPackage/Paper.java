package utilPackage;

import java.io.Serializable;

public class Paper implements Serializable, Cloneable, Comparable<Paper> {

	private static final long serialVersionUID = 1L;
	private int number;
	private String text;

	public Paper() {

	}

	public Paper(int number, String text) {
		this.number = number;
		this.text = text;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return "The number of Paper: " + this.number + "\nText: " + this.text;
	}

	public Object clone() throws CloneNotSupportedException {
		Paper paper = (Paper) super.clone();
		return paper;
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
		Paper p = (Paper) o;
		return this.number == p.number && this.text == p.text;
	}

	@Override
	public int compareTo(Paper o) {
		if (this.number > o.number) {
			return 1;
		}
		if (this.number < o.number) {
			return -1;
		}
		return 0;
	}

}