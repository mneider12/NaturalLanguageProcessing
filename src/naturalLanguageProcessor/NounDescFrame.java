package naturalLanguageProcessor;

import java.util.ArrayList;

/*
 * Purpose:	Frame holding a noun and the adjectives describing it
 */
public class NounDescFrame implements Frame {
	
	private Noun noun;
	private ArrayList<Adjective> adjectives;

	/*
	 * Purpose:	Initialize an empty frame
	 */
	public NounDescFrame() {
		adjectives = new ArrayList<Adjective>();
	}
	
	/*
	 * Purpose:	Initialize a fully formed frame
	 */
	public NounDescFrame(Noun noun, ArrayList<Adjective> adjectives) {
		
		this.noun = noun;
		this.adjectives = adjectives;
		
	}
	
	/*
	 * Purpose:	return the noun associated with this frame
	 * Returns:	noun
	 */
	public Noun getNoun() {
		return noun;
	}
	
	/*
	 * Purpose:	return the adjectives associated with this frame
	 * Returns:	adjectives
	 */
	public ArrayList<Adjective> getAdjectives() {
		return adjectives;
	}
	
	/*
	 * Purpose:	Add a word to this frame, or reset if that would be invalid
	 * Parameters:	
	 * 				word: word to attempt to add
	 */
	public void addWord(Word word){
		String wordType = word.getClass().getSimpleName();
		switch (wordType) {
		case "Adjective":
			adjectives.add((Adjective) word);
			break;
		case "Noun":
			if (noun != null) {
				adjectives = new ArrayList<Adjective>();
			}
			noun = (Noun) word;
			break;
		default:
			reset();
		}
	}
	
	/*
	 * Purpose:	reset this frame to its empty state
	 */
	public void reset() {
		noun = null;
		adjectives = new ArrayList<Adjective>();
	}
	
	/*
	 * Purpose:	return a String representation of this frame
	 * Returns:	The <noun> is <adjective>, <adjective>, ... and <adjective>
	 */
	public String toString() {
		String ret = "The " + noun.getWord();
		int size = adjectives.size();
		if (size > 0) {
			ret = ret + " is " + adjectives.get(0).getWord();
			for (int i = 1; i < size - 1; i++) {
				ret = ret + ", " + adjectives.get(i).getWord();
			}
			if (size > 2) {
				ret = ret + ",";
			}
			ret = ret + " and " + adjectives.get(size - 1).getWord();
		}
		
		return ret;
	}

	/*
	 * Purpose:	Check whether this frame is in a valid complete state
	 * Returns:	True if there is a noun set, otherwise false
	 */
	public boolean isComplete() {
		return noun != null;
	}
}
