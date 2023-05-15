package utilPackage;

import java.io.Serializable;

/**
 * @generated
 */
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	/// The title of this news (ex. THE BEST PROGRAMM EVER!)
	private String title;

	/**
	 * @generated
	 */
	/// The text of this news
	private String text;

	/// Default constructor
	public News() {
		title = "TEST NEWS";
		text = "some text";
	}

	/// Constructor
	public News(String title, String text) {
		this.text = text;
		this.title = title;
	}

	public String toString() {
		return title + "\n" + text;
	}

	/**
	 * @generated
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @generated
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @generated
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * @generated
	 */
	public void setText(String text) {
		this.text = text;
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
		News news = (News) o;
		return this.title == news.title && this.text == news.title;
	}
}
