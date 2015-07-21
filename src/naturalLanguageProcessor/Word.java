package naturalLanguageProcessor;

public class Word implements Comparable<Word> {
	
	private String word;	// String value of the word
	private wordType type;	// type of word (noun, verb, etc...)

	/*
	 * Purpose:	Initialize a shell word
	 */
	public Word() {
		type = wordType.generic;
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
	 * Purpose:	Give child classes the ability to set their type
	 */
	public void setType(wordType type) {
		this.type = type;
	}
	
	/*
	 * Purpose:	Easily read the type of a Word
	 * Returns:	type of Word
	 */
	public wordType getType() {
		return type;
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
	 * 			and then type abbreviation
	 * Parameters:	otherWord is the word we are comparing against
	 * Returns: a negative number if this sorts before otherWord, 0 if they are equal and
	 * 			a positive number if it sorts after
	 * 
	 */
	@Override
	public int compareTo(Word otherWord) {
		
		return word.toString().compareTo(otherWord.getWord().toString());
		
	}
	
	/*
	 * Purpose:	String representation of a Word
	 * Returns:	the String value of the word and it's associated abbreviation
	 * 			e.g. 'house (n.)'
	 */
	public String toString() {
		return word + " (" + type.getAbbrev() + ")";
	}
	
	/*
	 * Purpose:	wordType will be associated with a Word to make it easier 
	 * 			to differentiate between different classes of words
	 */
	public enum wordType {
		noun, verb, adjective, generic;
		
		private final String NOUNABBREV = "n.";
		private final String ADJABBREV = "adj.";
		private final String VERBABBREV = "v.";
		
		/*
		 * Purpose:	return the abbreviation for a given wordType
		 * Returns:	Abbreviation associated with this wordType
		 */
		public String getAbbrev() {
			switch (this) {
			case noun:
				return NOUNABBREV;
			case verb:
				return VERBABBREV;
			case adjective:
				return ADJABBREV;
			default:
				return "";
			}
		}
	}
	
}
