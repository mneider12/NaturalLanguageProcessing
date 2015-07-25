package naturalLanguageProcessor;

import java.util.ArrayList;

public class Utilities {

	private Utilities() {
		
	}
	
	public static ArrayList<Class<? extends Word>> getWordClasses() {
		ArrayList<Class<? extends Word>> classes = new ArrayList<Class<? extends Word>>();
		classes.add(Adjective.class);
		classes.add(Article.class);
		classes.add(Noun.class);
		classes.add(Preposition.class);
		classes.add(Pronoun.class);
		classes.add(Verb.class);
		
		return classes;
	}
}
