package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import naturalLanguageProcessor.Adjective;
import naturalLanguageProcessor.Article;
import naturalLanguageProcessor.Dictionary;
import naturalLanguageProcessor.Noun;
import naturalLanguageProcessor.NounDescFrame;
import naturalLanguageProcessor.Word;

import org.junit.Test;

/*
 * Purpose:	Test functions in NounDescFrame
 */
public class NounDescFrameTest {

	/*
	 * Purpose:	Test the addWord method in NounDescFrame
	 */
	@Test
	public void addWordTest() {
		Dictionary dict = new Dictionary("Dictionary.txt");
		NounDescFrame frame = new NounDescFrame();
		String sentence = "the big bad grey wolf ate the sweet frail grandmother";
		ArrayList<NounDescFrame> frames = new ArrayList<NounDescFrame>();
		for (String wordStr : sentence.split(" ")){ 
			Word word = dict.getWord(wordStr);
			frame.addWord(word);
			if (frame.isComplete()) {
				frames.add(frame);
				frame = new NounDescFrame();
			}
		}
		
		ArrayList<Adjective> adjectives = new ArrayList<Adjective>();
		adjectives.add(new Adjective("big"));
		adjectives.add(new Adjective("bad"));
		adjectives.add(new Adjective("grey"));
		Noun wolf = new Noun("wolf");
		NounDescFrame wolfFrame = frames.get(0);
		assertEquals(adjectives, wolfFrame.getAdjectives());
		assertEquals(wolf, wolfFrame.getNoun());
	}

	/*
	 * Purpose:	Test the isComplete function in NounDescTest
	 */
	@Test
	public void isCompleteTest() {
		NounDescFrame frame = new NounDescFrame();
		assertTrue(frame.isComplete() == false);
		frame.addWord(new Article("the"));
		assertTrue(frame.isComplete() == false);
		frame.addWord(new Adjective("blue"));
		assertTrue(frame.isComplete() == false);
		frame.addWord(new Noun("bear"));
		assertTrue(frame.isComplete());	//NounDescFrame is complete once it has a noun
		
		// Check that is complete does not require an Adjective
		frame = new NounDescFrame();
		frame.addWord(new Noun("dog"));
		assertTrue(frame.isComplete());
	}
	
	/*
	 * Purpose:	Test the reset function in NounDescTest
	 */
	@Test
	public void resetTest() {
		NounDescFrame frame = new NounDescFrame();
		frame.addWord(new Adjective("green"));
		frame.addWord(new Noun("giraffe"));
		assertTrue(frame.getAdjectives().size() != 0);
		assertTrue(frame.getNoun() != null);
		frame.reset();
		assertTrue(frame.getAdjectives().size() == 0);
		assertTrue(frame.getNoun() == null);
	}
	
	/*
	 * Purpose:	Test the toString method in NounDescTest
	 */
	@Test
	public void toStringTest() {
		ArrayList<Adjective> adjectives = new ArrayList<Adjective>();
		adjectives.add(new Adjective("fiery"));
		adjectives.add(new Adjective("young"));
		Noun redhead = new Noun("redhead");
		NounDescFrame frame = new NounDescFrame(redhead, adjectives);
		assertEquals("The redhead is fiery and young", frame.toString());
		adjectives.add(new Adjective("brazen"));
		assertEquals("The redhead is fiery, young, and brazen", frame.toString());
	}
	
	
	
}
