package naturalLanguageProcessor;

public class Noun extends Word {
	
	private static final long serialVersionUID = 2021963842909618920L;
	private final String ABBREVIATION = "n.";
	
	public Noun(String wordStr) {
		super(wordStr);
	}
	
	public String getAbbrev() {
		return ABBREVIATION;
	}

}
