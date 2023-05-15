package userPackage;

import java.util.Vector;
import utilPackage.Paper;

public class Research {

	private Vector<Paper> papers;
	private String title;
	private User author;

	public Research() {

	}

	public Research(String title, Paper paper, User author) {
		this.papers = new Vector<Paper>();
		this.title = title;
		this.author = author;
	}

	public Vector<Paper> getPapers() {
		if (this.papers == null) {
			this.papers = new Vector<Paper>();
		}
		return this.papers;
	}

	public void setPapers(Vector<Paper> papers) {
		this.papers = papers;
	}

	public String toString() {
		return this.papers.toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
}