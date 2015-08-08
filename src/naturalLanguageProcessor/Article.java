package naturalLanguageProcessor;

public class Article extends Word {
	
	private static final long serialVersionUID = 5523752431436459006L;
	private final String ABBREVIATION = "art.";
	
	public Article(String wordStr) {
		super(wordStr);
	}

	public String getAbbrev() {
		return ABBREVIATION;
	}
}
