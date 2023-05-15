package userPackage;

import java.util.HashMap;
import java.util.Vector;

public class Language {
	private String lang;
	
	
	private HashMap<LanguageType,String> words;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public HashMap<LanguageType,String> getWords() {
		return words;
	}

	public void setWords(HashMap<LanguageType,String> words) {
		this.words = words;
	}
	
}
