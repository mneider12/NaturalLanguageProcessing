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
		for (String wordStr : sentence.split(" ")) {
			Word word = dictionary.getWord(wordStr);
			if (word.getClass().getSimpleName().equals("Generic")) {
				if (interactive) {
					System.out.println("What type of word is " + wordStr + "?");
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
					addWord(word.getWord(), type);
				} else {
					
				}
			} else {
				words.add(word);
			}
		}
	
	}
	
	/*
	 * Purpose:	add a word to words based on a String type of the word to add.
	 * 			Used for learning from a menu driver
	 * Parameters:
	 * 				wordStr: the string value of the word to add
	 * 				type:	the string value of the type of word
	 */
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
		PrepClauseFrame prepFrame = new PrepClauseFrame();
		NounDescFrame nounDescFrame = new NounDescFrame();
		for (Word word : words) {
			nounDescFrame.addWord(word);
			if (nounDescFrame.isComplete()) {
				frames.add(nounDescFrame);
				nounDescFrame = new NounDescFrame();
			}
			prepFrame.addWord(word);
			if (prepFrame.isComplete()) {
				frames.add(prepFrame);
				prepFrame = new PrepClauseFrame();
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
	
	/*
	 * Purpose: Override toString behavior. Describe frames for current sentence
	 * Returns: toString method on all stored frames
	 */
	public String toString(){
		return frames.toString();
	}
	
	
	
}
