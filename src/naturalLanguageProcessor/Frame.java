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
}
