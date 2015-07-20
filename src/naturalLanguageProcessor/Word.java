package naturalLanguageProcessor;

public class Word {
	
	private String word;	// String value of the word

	/*
	 * Purpose:	Initialize a shell word
	 */
	public Word() {
		
	}
	
	/*
	 * Purpose:	Initialize a word with a known String
	 * Parameters:	
	 * 				word:	String value to store in memory
	 */
	public Word(String word) {
		this();
		setWord(word);
	}
	
	/*
	 * Purpose:	Set the String value of a word into memory
	 * Parameters:
	 * 				word:	String value to store in memory
	 */
	public void setWord(String word) {
		
		this.word = word;
	}
	
	/*
	 * Purpose:	Return the String word stored in memory
	 */
	public String getWord() {
		
		return word;
	}
	
}
