package naturalLanguageProcessor;

public class Adjective extends Word {
	
	private final String ABBREVIATION = "adj.";
	
	public Adjective(String wordStr) {
		super(wordStr);
		setType(wordType.adjective);
	}
	
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
