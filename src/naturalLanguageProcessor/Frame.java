package naturalLanguageProcessor;

public interface Frame {
	
	/*
	 * Purpose:	Given a word, add it to this frame as appropriate or reset the frame if 
	 * 			this would be invalid
	 * Parameters:	
	 * 				word:	the word to attempt to add to the frame
	 */
	public void addWord(Word word);
	
	/*
	 * Purpose: Check if the current state of the frame is complete
	 * Returns:	True if the frame is complete, otherwise false
	 */
	public boolean isComplete();
	
	/*
	 * Purpose:	reset the frame to an initial state
	 */
	public void reset();
	
}
