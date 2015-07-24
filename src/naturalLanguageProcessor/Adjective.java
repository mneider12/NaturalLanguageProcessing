package naturalLanguageProcessor;

public class Adjective extends Word {
	
	private final String ABBREVIATION = "adj.";	// abbreviation for adjectives
	
	/*
	 * Purpose:	To initialize an Adjective with a word
	 */
	public Adjective(String wordStr) {
		super(wordStr);
	}
	
	/*
	 * Purpose:	return the abbreviation for Adjective
	 */
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
