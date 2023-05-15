package viewPackage;

import java.util.Vector;

/**
 * @generated
 */
public class Language {

	private static Vector<String> english;

	public static Vector<String> getLanguage(String lang) {
		if (lang.equals("Eng")) {
			return english;
		}
		return null;
	}

}
