package naturalLanguageProcessor;

public class Generic extends Word {
	
	private static final long serialVersionUID = 2131696429347411279L;
	private final String ABBREVIATION = "";
	
	public Generic(String wordStr) {
		super(wordStr);
	}

	public String getAbbrev() {
		return ABBREVIATION;
	}
}
