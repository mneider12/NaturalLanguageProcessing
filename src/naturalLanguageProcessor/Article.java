package naturalLanguageProcessor;

public class Article extends Word {
	
	private final String ABBREVIATION = "art.";
	
	public Article(String wordStr) {
		super(wordStr);
	}

	public String getAbbrev() {
		return ABBREVIATION;
	}
}
