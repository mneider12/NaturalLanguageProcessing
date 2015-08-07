package naturalLanguageProcessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.TreeSet;

public class Dictionary implements Serializable {
	
	private static final long serialVersionUID = -3037457060036719550L;	// generated serial ID

	private TreeSet<Word> words;	// store words in local memory. Currently using a Tree since
									// lookup often involves checking for nearby words
	
	private String filePath;

	/*
	 * Purpose:	Initialize an empty dictionary
	 */
	public Dictionary() {
		filePath = "";
		words = new TreeSet<Word>();
	}
	
	/*
	 * Purpose: Initialize a dictionary with words defined in a text file
	 * Parameters:
	 * 				filePath:	location of text file used to build dictionary
	 * 							see load for file format
	 */
	public Dictionary(String filePath) {
		this();
		load(filePath);
	}
	
	/*
	 * Purpose: Load dictionary data into local memory from a text file
	 * Parameters:
	 * 				filePath:	location of text file used to build dictionary
	 * 							files should have the format on each line:
	 * 							<word>|<type of word>
	 * Returns:	true if all lines in file can be read successfully, otherwise false
	 */
	public boolean load(String filePath) {
		this.filePath = filePath;
		words = new TreeSet<Word>();
		
		ObjectInputStream obj_in = null;
		
		try {
		// Read from disk using FileInputStream
		FileInputStream f_in = new 
			FileInputStream(filePath);

		// Read object using ObjectInputStream
		obj_in = new ObjectInputStream (f_in);

		// Read an object
		Word word = (Word) obj_in.readObject();

		words.add(word);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				obj_in.close();
			} catch (NullPointerException | IOException e) {
			
			}
		}
		
		return true;
	}
	
	/*
	 * Purpose:	Adds a word to the words Set if line is in the proper format
	 * Parameters:
	 * 				line:	a single line in a text file. See load for proper format
	 * Returns:	True if a word was successfully added, otherwise false
	 */
	private boolean add(String line) {
//TODO - add serializable retrieval
		
		int index = line.indexOf('|');
		if (index <= 0) {
			return false;
		}
		String wordStr;
		String type;
		try {
			wordStr  = line.substring(0, index);;
			type = line.substring(index + 1);
		} catch (StringIndexOutOfBoundsException e) {
			return false;
		}
		
		Word newWord;
		switch(type) {
		case "adjective":
			newWord = new Adjective(wordStr);
			break;
		case "verb":
			newWord = new Verb(wordStr);
			break;
		case "noun":
			newWord = new Noun(wordStr);
			break;
		case "article":
			newWord = new Article(wordStr);
			break;
		case "preposition":
			newWord = new Preposition(wordStr);
			break;
		default:
			newWord = new Generic(wordStr);
		}
		
		words.add(newWord);
		
		return true;
	}
	
	/*
	 * Purpose:	Add a word to this Dictionary
	 */
	public void addWord(Word word) {
		words.add(word);
	}
	
	/*
	 * Purpose: Add a word to this dictionary and store it to memory
	 */
	public void addWordToFile(Word word) {
		addWord(word);
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream(filePath);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(word);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	/*
	 * Purpose: Remove a word from this Dictionary
	 */
	public void removeWord(Word word) {
		words.remove(word);
	}
	
	
	/*
	 * Purpose:	Check if a string is defined in this dictionary
	 * Parameters:
	 * 				word:	string value to lookup in dictionary
	 * Returns:	true 'word' is found in the dictionary, otherwise false
	 */
	public boolean hasWord(String word) {
		Word checkWord = new Generic(word);
		try {
			if (words.ceiling(checkWord).getWord().equals(word)){
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	/*
	 * Purpose:	Get method for filePath
	 * Returns:	Returns the file path for this Dictionary
	 */
	public String getFilePath() {
		return filePath;
	}
	
	/*
	 * Purpose:	Find a word in the dictionary matching the word string
	 * Parameters:	
	 * 				wordStr:	word to search for
	 * Returns:	A Word from the dictionary if one matches wordStr, else a generic word
	 */
	public Word getWord(String wordStr) {
		Generic word = new Generic(wordStr);
		Word checkWord = words.ceiling(word);
		if (checkWord == null) { 
			return word;
		}
		if (checkWord.getWord().equals(word.getWord())) {
			return checkWord;
		}
		return word;
	}
	
	/*
	 * Purpose:	Two dictionaries are equal if they have the same filePath
	 * Parameters:
	 * 				otherDict:	Dictionary to compare with
	 * Returns:	True if the two dictionaries have the same filePath, otherwise false
	 * 
	 */
	public boolean equals(Object otherDict) {
		if (filePath.equals(((Dictionary) otherDict).getFilePath())) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Purpose:	return a String representation of this Dictionary
	 * Returns:	String representation of the words in this dictionary
	 */
	public String toString(){
		return words.toString();
	}
	
	
}
