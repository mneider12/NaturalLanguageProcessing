package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import naturalLanguageProcessor.Adjective;
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

}
