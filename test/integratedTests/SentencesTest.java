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
	}

}
