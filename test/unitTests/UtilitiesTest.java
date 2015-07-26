package unitTests;

import static org.junit.Assert.*;

import naturalLanguageProcessor.Adjective;
import naturalLanguageProcessor.Article;
import naturalLanguageProcessor.Noun;
import naturalLanguageProcessor.Preposition;
import naturalLanguageProcessor.Pronoun;
import naturalLanguageProcessor.Utilities;
import naturalLanguageProcessor.Verb;
import org.junit.Test;

public class UtilitiesTest {

	/*
	 * Purpose: Test the getWordClasses method returns the expected list of classes
	 */
	@Test
	public void getWordClasses() {
		Object[] classArr = {Adjective.class, Article.class, Noun.class, Preposition.class,
				Pronoun.class, Verb.class};

		assertArrayEquals(classArr, Utilities.getWordClasses().toArray());
	}

}
