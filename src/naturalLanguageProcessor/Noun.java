package naturalLanguageProcessor;

public class Noun extends Word {
	
	private final String ABBREVIATION = "n.";
	
	public Noun(String wordStr) {
		super(wordStr);
		setType(wordType.noun);
	}
	
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
