package naturalLanguageProcessor;

import java.util.ArrayList;

/*
 * Purpose:	Statically callable, broadly useful utilities
 */
public class Utilities {

	/*
	 * Purpose:	All calls to Utilities should be static
	 */
	private Utilities() {
		
	}
	
	/*
	 * Purpose:	Return the list of instantiable classes that extend Word
	 * Returns:	An ArrayList with all of the classes that extend Word
	 */
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
