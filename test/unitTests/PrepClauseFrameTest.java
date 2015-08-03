package unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import naturalLanguageProcessor.Article;
import naturalLanguageProcessor.Dictionary;
import naturalLanguageProcessor.Noun;
import naturalLanguageProcessor.PrepClauseFrame;
import naturalLanguageProcessor.Preposition;
import naturalLanguageProcessor.Verb;
import naturalLanguageProcessor.Word;

import org.junit.Test;

public class PrepClauseFrameTest {
	
	/*
	 * Purpose:	Test the addWord method in PrepClauseFrame
	 */
	@Test
	public void addWordTest() {
		Dictionary dict = new Dictionary("Dictionary.txt");
		PrepClauseFrame frame = new PrepClauseFrame();
		String sentence = "the cow jumped over the moon";
		ArrayList<PrepClauseFrame> frames = new ArrayList<PrepClauseFrame>();
		for (String wordStr : sentence.split(" ")){ 
			Word word = dict.getWord(wordStr);
			frame.addWord(word);
			if (frame.isComplete()) {
				frames.add(frame);
				frame = new PrepClauseFrame();
			}
		}
		
		Noun subject = new Noun("cow");
		Verb action = new Verb("jumped");
		Preposition prep = new Preposition("over");
		Noun target = new Noun("moon");
		PrepClauseFrame cowFrame = frames.get(0);
		assertEquals(subject, cowFrame.getSubject());
		assertEquals(action, cowFrame.getAction());
		assertEquals(prep, cowFrame.getPrep());
		assertEquals(target, cowFrame.getTarget());
	}
	
	/*
	 * Purpose: Test the isComplete method in PrepClauseFrame
	 */
	@Test
	public void isCompleteTest() {
		PrepClauseFrame frame = new PrepClauseFrame();
		frame.addWord(new Noun("cow"));
		assertTrue(frame.isComplete() == false);
		frame.addWord(new Verb("jumped"));
		assertTrue(frame.isComplete() == false);
		frame.addWord(new Preposition("over"));
		assertTrue(frame.isComplete() == false);
		frame.addWord(new Article("the"));
		assertTrue(frame.isComplete() == false);
		frame.addWord(new Noun("moon"));
		assertTrue(frame.isComplete());
	}
	
	/*
	 * Purpose:	Test the reset method in PrepClauseFrame
	 */
	@Test
	public void resetTest() {
		PrepClauseFrame frame = new PrepClauseFrame(new Noun("fox"), new Verb("jumped"), 
				new Preposition("over"), new Noun("dog"));
		assertTrue(frame.getPrep() != null);
		frame.reset();
		assertTrue(frame.getSubject() == null);
		assertTrue(frame.getAction() == null);
		assertTrue(frame.getPrep() == null);
		assertTrue(frame.getTarget() == null);
	}
}
