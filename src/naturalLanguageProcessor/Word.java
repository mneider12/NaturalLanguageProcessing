package naturalLanguageProcessor;

import java.io.Serializable;

public abstract class Word implements Comparable<Word>, Serializable {
	

	private static final long serialVersionUID = -6669399627554690594L;
	
	private String wordStr;	// String value of the word

	/*
	 * Purpose:	Initialize a word with a known String
	 * Parameters:	
	 * 				wordStr:	String value to store in memory
	 */
	public Word(String wordStr) {
		setWord(wordStr);
	}
	
	/*
	 * Purpose:	Set the String value of a word into memory
	 * Parameters:
	 * 				word:	String value to store in memory
	 */
	public void setWord(String wordStr) {
		
		this.wordStr = wordStr;
	}
	
	/*
	 * Purpose:	Return the String word stored in memory
	 */
	public String getWord() {
		
		return wordStr;
	}
	
	public abstract String getAbbrev();

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

		return toString().compareTo(otherWord.toString());
		
	}
	
	/*
	 * Purpose:	String representation of a Word
	 * Returns:	the String value of the word and it's associated abbreviation
	 * 			e.g. 'house (n.)'
	 */
	public String toString() {
		return wordStr + " (" + getAbbrev() + ")";
	}
	
	public int hashCode() {
		return (wordStr + "(" + getAbbrev() + ")").hashCode();
	}
	
	public boolean equals(Object otherWord) {
		if (!(this.getClass() == otherWord.getClass())) {
			return false;
		}
		if (wordStr.equals(((Word) otherWord).getWord())) {
			return true;
		}
		return false;
	}
	
}
