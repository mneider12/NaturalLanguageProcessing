package naturalLanguageProcessor;

import java.util.ArrayList;

public class NLPagent {
	
	private String sentence;	// Sentence that can be queried

	/*
	 * Purpose:	Initialize an NLPagent with nothing set in memory
	 */
	public NLPagent() {
		
	}
	
	/*
	 * Purpose:	Initialize an NLPagent with a sentence set
	 */
	public NLPagent(String sentence) {
		this();
		setSentence(sentence);
	}
	
	
	/*
	 * Purpose:	Set the sentence that the NLPagent stores in memory
	 * Parameters:	
	 * 				sentence:	the sentence to be stored in memory
	 */
	public void setSentence(String sentence) {
		
		this.sentence = sentence;
		
	}
	
	
	/*
	 * Purpose:	Return the sentence stored in memory
	 * Returns:	sentence if it is set, otherwise an empty string
	 */
	public String getSentence() {
		
		if (sentence == null) {
			return "";
		} else {
			return sentence;
		}
		
	}

	/*
	 * Purpose:	Return the adjectives that are associated with the given noun in sentence
	 * Parameters:	
	 * 				noun: String key indicating which noun to find adjectives for
	 * Returns:	ArrayList of Adjectives describing the given noun
	 */
	public ArrayList<Adjective> getAdjectives(String noun) {
		//TODO Implement
		return null;
	}
	
	
	
}
