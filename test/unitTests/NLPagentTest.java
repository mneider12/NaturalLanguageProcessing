package unitTests;

import static org.junit.Assert.*;
import naturalLanguageProcessor.NLPagent;

import org.junit.Test;

public class NLPagentTest {

	@Test
	public void setDictTest() {
		NLPagent agent = new NLPagent("This is not a drill");
		agent.setDictionary("TestDictionary.txt");
	}
	
}
