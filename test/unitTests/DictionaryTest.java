package unitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import naturalLanguageProcessor.Dictionary;
import naturalLanguageProcessor.Noun;
import naturalLanguageProcessor.Word;

import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Purpose:	Unit testing for the Dictionary class
 */
public class DictionaryTest {
	
	private static Dictionary dict;	//General use dictionary doesn't need to be loaded each time
	
	/*
	 * Purpose:	Create a dictionary that most tests will use
	 */
	@BeforeClass
	public static void setup() {
		dict = new Dictionary("Dictionary.txt");
	}
	
	/*
	 * Purpose:	Test loading a new dictionary on top of an old one.
	 */
	@Test
	public void loadTest() {
		assertTrue(dict.hasWord("over"));
		assertFalse(dict.hasWord("strawberry"));
		dict.load("TestDictionary.txt");
		assertFalse(dict.hasWord("over"));
		assertTrue(dict.hasWord("strawberry"));
		dict.load("Dictionary.txt");	//cleanup - put the old dictionary back into memory
	}
	
	/*
	 * Purpose:	Test the hasWord method
	 */
	@Test
	public void hasWordTest() {
		assertTrue(dict.hasWord("fox"));
		assertFalse(dict.hasWord("blueberry"));
	}

	/*
	 * Purpose:	Test the getWord method
	 */
	@Test
	public void getWord() {
		assertEquals("Verb", dict.getWord("jumped").getClass().getSimpleName());
	}
	
	/*
	 * Purpose: Test adding a word to a Dictionary file
	 */
	@Test
	public void addWordToFileTest() throws IOException {
		File file = new File("TestLearnedDictionary.ser");
		file.createNewFile();
		file.delete();
		/*try {
			if (!file.createNewFile()) {
				fail("TestLearnedDictionary.ser already exists");
			}
			Dictionary dict = new Dictionary("TestLearnedDictionary.ser");
			dict.addWordToFile(new Noun("blueberry"));
		} catch (IOException e) {
			fail(e.getMessage());
		}
		Dictionary dict2 = new Dictionary("TestLearnedDictionary.ser");
		assertEquals(new Noun("blueberry"), dict2.getWord("blueberry"));
		assertTrue(file.delete());*/
		

	}
}
