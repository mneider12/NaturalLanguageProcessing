package integratedTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import naturalLanguageProcessor.Adjective;
import naturalLanguageProcessor.NLPagent;

import org.junit.Test;

public class SentencesTest {

	/*
	 * Purpose:	Check that we can extract adjectives positioned directly before a noun
	 */
	@Test
	public void quickFox() {
		NLPagent agent = new NLPagent("The quick brown fox jumped over the lazy dog");
		ArrayList<Adjective> foxDesc = agent.getAdjectives("fox");
		ArrayList<Adjective> foxDescAns = new ArrayList<Adjective>();
		foxDescAns.add(new Adjective("quick"));
		foxDescAns.add(new Adjective("brown"));
		assertArrayEquals(foxDescAns.toArray(), foxDesc.toArray());
		
		ArrayList<Adjective> dogDesc = agent.getAdjectives("dog");
		ArrayList<Adjective> dogDescAns = new ArrayList<Adjective>();
		dogDescAns.add(new Adjective("lazy"));
		assertArrayEquals(dogDescAns.toArray(), dogDesc.toArray());
		
		// check that non-nouns do not get associated with adjectives
		ArrayList<Adjective> jump = agent.getAdjectives("jump");
		assertEquals(null, jump);
	}

}
