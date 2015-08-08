package naturalLanguageProcessor;

public class Adjective extends Word {
	

	private static final long serialVersionUID = 725403016012167252L;
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
