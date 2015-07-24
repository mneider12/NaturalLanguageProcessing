package naturalLanguageProcessor;

import java.util.ArrayList;

public class Frame {
	
	private Noun noun;
	private ArrayList<Adjective> adjectives;

	public Frame() {
		
	}
	
	public Frame(Noun noun, ArrayList<Adjective> adjectives) {
		
		this.noun = noun;
		this.adjectives = adjectives;
		
	}
	
	public Noun getNoun() {
		return noun;
	}
	
	public ArrayList<Adjective> getAdjectives() {
		return adjectives;
	}
	
	public String toString() {
		String ret = "The " + noun.getWord() + " is ";
		int size = adjectives.size();
		if (size > 0) {
			ret = ret + " is " + adjectives.get(0).getWord();
		}
		for (int i = 1; i < size; i++) {
			ret = ret + " and " + adjectives.get(i).getWord();
		}
		return ret;
	}
}
