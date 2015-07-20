package naturalLanguageProcessor;

public class Word implements Comparable<Word> {
	
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

	/*
	 * Purpose:	Implements Comparable and can be used to sort words by alphabetical order 
	 * 			and then type
	 * Returns:
	 * 
	 */
	@Override
	public int compareTo(Word otherWord) {
		
		int stringCompare = word.compareTo(otherWord.getWord());
		
		//break ties between the same word with a different type
		//alphabetical by type name
		if (stringCompare == 0) {
			return this.getClass().getName().compareTo(otherWord.getClass().getName());
		} else {
			return word.compareTo(otherWord.getWord());
		}
	}
	
}
