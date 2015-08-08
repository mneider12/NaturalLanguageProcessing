package naturalLanguageProcessor;


public class Preposition extends Word {
	
	private static final long serialVersionUID = 1552922832522580587L;
	private final String ABBREVIATION = "prep.";
	
	public Preposition(String wordStr) {
		super(wordStr);
	}
	
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
