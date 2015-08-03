package naturalLanguageProcessor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Dictionary {
	
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
		
		Scanner r = null;
		try{
			r = new Scanner(new File(filePath));
		} catch(IOException e) {
			System.out.println(e);
			return false;
		}
		
		int lnCnt = 0;
		boolean success = true;
		while(r.hasNext()) {
			lnCnt++;
			String line = r.nextLine();
			if (add(line) == false) {
				System.out.println("Line " + lnCnt + " \"" + line + "\" was unreadable");
				success = false;
			}
		}
		r.close();
		return success;
	}
	
	/*
	 * Purpose:	Adds a word to the words Set if line is in the proper format
	 * Parameters:
	 * 				line:	a single line in a text file. See load for proper format
	 * Returns:	True if a word was successfully added, otherwise false
	 */
	private boolean add(String line) {
		
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
}
