package naturalLanguageProcessor;

public class Verb extends Word{
	
	private static final long serialVersionUID = 487107796794927788L;
	private final String ABBREVIATION = "v.";

	public Verb(String wordStr) {
		super(wordStr);
	}
	
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
