package naturalLanguageProcessor;


public class Preposition extends Word {
	
	private final String ABBREVIATION = "prep.";
	
	public Preposition(String wordStr) {
		super(wordStr);
	}
	
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
