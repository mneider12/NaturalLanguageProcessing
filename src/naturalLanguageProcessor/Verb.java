package naturalLanguageProcessor;

public class Verb extends Word{
	
	private final String ABBREVIATION = "v.";

	public Verb(String wordStr) {
		super(wordStr);
		setType(wordType.verb);
	}
	
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
