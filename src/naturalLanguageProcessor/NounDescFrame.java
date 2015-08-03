package naturalLanguageProcessor;

import java.util.ArrayList;

/*
 * Purpose:	Frame holding a noun and the adjectives describing it
 */
public class NounDescFrame implements Frame {
	
	private Noun noun;
	private ArrayList<Adjective> adjectives;

	public NounDescFrame() {
		
	}
	
	public NounDescFrame(Noun noun, ArrayList<Adjective> adjectives) {
		
		this.noun = noun;
		this.adjectives = adjectives;
		
	}
	
	public Noun getNoun() {
		return noun;
	}
	
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
	
	public void reset() {
		noun = null;
		adjectives = new ArrayList<Adjective>();
	}
	
	public String toString() {
		String ret = "The " + noun.getWord();
		int size = adjectives.size();
		if (size > 0) {
			ret = ret + " is " + adjectives.get(0).getWord();
		}
		for (int i = 1; i < size; i++) {
			ret = ret + " and " + adjectives.get(i).getWord();
		}
		return ret;
	}

	@Override
	public boolean isComplete() {
		return noun != null;
	}
}
