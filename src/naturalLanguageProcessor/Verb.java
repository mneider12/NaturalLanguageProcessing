package naturalLanguageProcessor;

public class Verb extends Word{
	
	private final String ABBREVIATION = "v.";

	public Verb(String wordStr) {
		super(wordStr);
	}
	
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
