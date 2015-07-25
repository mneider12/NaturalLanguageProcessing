package naturalLanguageProcessor;

import java.util.ArrayList;

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
		words = new ArrayList<Word>();
		frames = new ArrayList<Frame>();
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
		if (sentence != null) {
			setSentence(sentence);		// Re-read sentence
		}
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
		words = new ArrayList<Word>(); 
		String type;
		for (String word : sentence.split(" ")) {
			type = dictionary.getWord(word).getClass().getSimpleName();
			switch(type) {
			case "Adjective":
				words.add(new Adjective(word));
				break;
			case "Noun":
				words.add(new Noun(word));
				break;
			case "Verb":
				words.add(new Verb(word));
				break;
			case "Article":
				words.add(new Article(word));
				break;
			case "Preposition":
				words.add(new Preposition(word));
				break;
			default:
				words.add(new Generic(word));
			}
		}
	}
	
	/*
	 * Purpose:	Loop through the words in the sentence and organize them into frames
	 *
	 */
	public void setFrames() {
		frames = new ArrayList<Frame>();
		ArrayList<Adjective> adjectives = new ArrayList<Adjective>();
		Frame frame;
		for (Word word : words) {
			if (word.getClass() == Adjective.class) {
				adjectives.add((Adjective) word);
			} else if (word.getClass() == Noun.class) {
				frame = new Frame((Noun) word, adjectives);
				frames.add(frame);
				adjectives = new ArrayList<Adjective>();
			}
			
		}
	}
	
	/*
	 * Purpose: Return the frames array
	 * Returns: Frames array
	 */
	public ArrayList<Frame> getFrames() {
		return frames;
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
	 * Purpose:	Return the words ArrayList
	 * Returns:	words
	 */
	public ArrayList<Word> getWords() {
		return words;
	}

	/*
	 * Purpose:	Return the adjectives that are associated with the given noun in sentence
	 * Parameters:	
	 * 				noun: String key indicating which noun to find adjectives for
	 * Returns:	ArrayList of Adjectives describing the given noun
	 */
	public ArrayList<Adjective> getAdjectives(String noun) {
		for (Frame frame : frames) {
			if (frame.getNoun().getWord().equals(noun)) {
				return frame.getAdjectives();
			}
		}
		return new ArrayList<Adjective>();
	}
	
	
	
}
