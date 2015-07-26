package naturalLanguageProcessor;

import java.util.ArrayList;

public class NLPagent {
	
	private String sentence;	// Sentence that can be queried
	private ArrayList<Frame> frames;
	private ArrayList<Word> words;
	private final String DEFAULTDICT = "Dictionary.txt";
	private Dictionary dictionary;
	private boolean interactive;	// should the agent respond to user and learn

	/*
	 * Purpose:	Initialize an NLPagent with nothing set in memory
	 */
	public NLPagent() {
		words = new ArrayList<Word>();
		frames = new ArrayList<Frame>();
		setDictionary(DEFAULTDICT);
		sentence = "";
		interactive = false;
	}
	
	/*
	 * Purpose:	Initialize an NLPagent with a sentence set
	 * Parameters:	
	 * 				sentence:	sentence to store in memory
	 */
	public NLPagent(String sentence) {
		this();
		setSentence(sentence);
		
	}
	
	/*
	 * Purpose:	Initialize an NLPagent in interactive mode
	 * Parameters:	
	 * 				sentence:	sentence to store in memory
	 * 				interactive:	boolean whether interactive mode should be on
	 */
	public NLPagent(String sentence, boolean interactive) {
		this();
		this.interactive = interactive;
		setDictionary(DEFAULTDICT);
		setSentence(sentence);
	}
	
	/*
	 * Purpose:	Turn on interactive mode
	 */
	public void interactiveOn() {
		interactive = true;
	}
	
	/*
	 * Purpose:	Turn off interactive mode
	 */
	public void interactiveOff() {
		interactive = false;
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
			if (type.equals("Generic") && interactive) {
				System.out.println("What type of word is " + word + "?");
				ArrayList<String> choices = new ArrayList<String>();
				for (Class<? extends Word> wordClass : Utilities.getWordClasses()) {
					choices.add(wordClass.getSimpleName());
				}
				choices.add("unknown");
				Menu menu = new Menu(choices);
				type = "";
				while (type.equals("")) {
					type = menu.promptChoices();
				}
				if (type.equals("unknown")){
					type = "generic";
				}
			}
			addWord(word, type);
		}
	
	}
	
	private void addWord(String wordStr, String type) {
		switch(type) {
		case "Adjective":
			words.add(new Adjective(wordStr));
			break;
		case "Noun":
			words.add(new Noun(wordStr));
			break;
		case "Verb":
			words.add(new Verb(wordStr));
			break;
		case "Article":
			words.add(new Article(wordStr));
			break;
		case "Preposition":
			words.add(new Preposition(wordStr));
			break;
		case "Pronoun":
			words.add(new Pronoun(wordStr));
			break;
		default:
			if (interactive) {
			
				
			} else {
				words.add(new Generic(wordStr));
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
		NounDescFrame nounDescFrame;
		for (Word word : words) {
			// This loop finds Frames with a noun preceeded by adjectives
			if (word.getClass() == Adjective.class) {
				adjectives.add((Adjective) word);
			} else if (word.getClass() == Noun.class) {
				nounDescFrame = new NounDescFrame((Noun) word, adjectives);
				frames.add(nounDescFrame);
				adjectives = new ArrayList<Adjective>();
				
			} else {
				adjectives = new ArrayList<Adjective>();	//reset for non adj / nouns
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
			if (frame.getClass() == NounDescFrame.class) {
				if (((NounDescFrame) frame).getNoun().getWord().equals(noun)) {
					return ((NounDescFrame) frame).getAdjectives();
				}
			}
		}
		return new ArrayList<Adjective>();
	}

	public Noun getTarget(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
