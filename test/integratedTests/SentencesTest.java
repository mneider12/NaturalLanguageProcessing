package integratedTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import naturalLanguageProcessor.Adjective;
import naturalLanguageProcessor.NLPagent;

import org.junit.Test;

public class SentencesTest {

	@Test
	public void quickFox() {
		NLPagent agent = new NLPagent("The quick brown fox jumped over the lazy dog");
		ArrayList<Adjective> foxDesc = agent.getAdjectives("fox");
		ArrayList<Adjective> foxDescAns = new ArrayList<Adjective>();
		foxDescAns.add(new Adjective("quick"));
		foxDescAns.add(new Adjective("brown"));
		assertArrayEquals(foxDescAns.toArray(), foxDesc.toArray());
	}

}
