package naturalLanguageProcessor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Dictionary {
	
	private TreeSet<Word> words;

	/*
	 * Purpose:	Initialize an empty dictionary
	 */
	public Dictionary() {
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
	
	private boolean add(String line) {
		
		String[] pieces = line.split("|");
		String wordStr;
		String type;
		try {
			wordStr = pieces[0];
			type = pieces[1];
		} catch (NullPointerException e) {
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
		default:
			newWord = new Word(wordStr);
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
		Word checkWord = new Word("word");
		try {
			if (words.floor(checkWord).getWord().equals(word)){
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}
		
	}
}
