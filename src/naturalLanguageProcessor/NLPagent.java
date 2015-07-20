package naturalLanguageProcessor;

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
	
	
	
}
