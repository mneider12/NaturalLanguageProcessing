package naturalLanguageProcessor;

import java.util.ArrayList;

import naturalLanguageProcessor.Word.wordType;

public class NLPagent {
	
	private String sentence;	// Sentence that can be queried
	private ArrayList<Frame> frames;
	private ArrayList<Word> words;
	private final String DEFAULTDICT = "Dictionary.txt";
	private Dictionary dictionary;

	/*
	 * Purpose:	Initialize an NLPagent with nothing set in memory
	 */
	public NLPagent() {
		
	}
	
	/*
	 * Purpose:	Initialize an NLPagent with a sentence set
	 */
	public NLPagent(String sentence) {
		this();
		setDictionary(DEFAULTDICT);
		setSentence(sentence);
		
	}
	
	/*
	 * Purpose:	set the dictionary for the agent
	 */
	public void setDictionary(String filePath) {
		dictionary = new Dictionary(filePath);
	}
	
	/*
	 * Purpose:	Set the sentence that the NLPagent stores in memory
	 * Parameters:	
	 * 				sentence:	the sentence to be stored in memory
	 */
	public void setSentence(String sentence) {
		
		this.sentence = sentence;
		setWords();
		setFrames();
		
	}
	
	/*
	 * Purpose:	Parse sentence into words
	 * Prerequisites:	sentence must not be null
	 */
	public void setWords() {
		wordType type;
		for (String word : sentence.split(" ")) {
			type = dictionary.getType(word);
			switch(type) {
			case adjective:
				words.add(new Adjective(word));
			case noun:
				words.add(new Noun(word));
			case verb:
				words.add(new Verb(word));
			default:
				words.add(new Word(word));
			}
		}
	}
	
	/*
	 * Purpose:	Loop through the words in the sentence and organize them into frames
	 *
	 */
	public void setFrames() {
		ArrayList<Adjective> adjectives = new ArrayList<Adjective>();
		Frame frame;
		for (Word word : words) {
			if (word.getClass() == Adjective.class) {
				adjectives.add((Adjective) word);
			} else if (word.getClass() == Noun.class) {
				frame = new Frame((Noun) word, adjectives);
				
			}
			
		}
	}
	
	
	/*
	 * Purpose:	Return the sentence stored in memory
	 * Returns:	sentence if it is set, otherwise an empty string
	 */
	public String getSentence() {
		
		if (sentence == null) {
			return "";
		} else {
			return sentence;
		}
		
	}

	/*
	 * Purpose:	Return the adjectives that are associated with the given noun in sentence
	 * Parameters:	
	 * 				noun: String key indicating which noun to find adjectives for
	 * Returns:	ArrayList of Adjectives describing the given noun
	 */
	public ArrayList<Adjective> getAdjectives(String noun) {
		
		return null;
	}
	
	
	
}
