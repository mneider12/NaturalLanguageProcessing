package naturalLanguageProcessor;

import java.util.ArrayList;

public class Frame {
	
	private Noun noun;
	private ArrayList<Adjective> adjectives;

	public Frame() {
		
	}
	
	public Frame(Noun noun, ArrayList<Adjective> adjectives2) {
		
		this.noun = noun;
		this.adjectives = adjectives2;
		
	}
}
