package naturalLanguageProcessor;

public class Generic extends Word {
	
	private final String ABBREVIATION = "";
	
	public Generic(String wordStr) {
		super(wordStr);
	}

	public String getAbbrev() {
		return ABBREVIATION;
	}
}
