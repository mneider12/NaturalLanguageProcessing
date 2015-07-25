package naturalLanguageProcessor;

public class Pronoun extends Word {
	
	private final String ABBREVIATION = "pro.";
	
	public Pronoun(String wordStr) {
		super(wordStr);
	}

	@Override
	public String getAbbrev() {
		return ABBREVIATION;
	}
}
