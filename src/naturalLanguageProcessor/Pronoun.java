package naturalLanguageProcessor;

public class Pronoun extends Word {
	
	private static final long serialVersionUID = -6884704099310374328L;
	private final String ABBREVIATION = "pro.";
	
	public Pronoun(String wordStr) {
		super(wordStr);
	}

	@Override
	public String getAbbrev() {
		return ABBREVIATION;
	}
}
