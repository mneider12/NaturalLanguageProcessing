package naturalLanguageProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * Purpose:	Statically callable, broadly useful utilities
 */
public class Utilities {

	/*
	 * Purpose:	All calls to Utilities should be static
	 */
	private Utilities() {
		
	}
	
	/*
	 * Purpose:	Return the list of instantiable classes that extend Word
	 * Returns:	An ArrayList with all of the classes that extend Word
	 */
	public static ArrayList<Class<? extends Word>> getWordClasses() {
		ArrayList<Class<? extends Word>> classes = new ArrayList<Class<? extends Word>>();
		classes.add(Adjective.class);
		classes.add(Article.class);
		classes.add(Noun.class);
		classes.add(Preposition.class);
		classes.add(Pronoun.class);
		classes.add(Verb.class);
		
		return classes;
	}
	
	/*
	 * Purpose:	Serialize a plain text dictionary file
	 * Parameters:	
	 * 				inputPath: filepath to input file
	 * 				outputPath:	filepath to output file
	 * 				overwrite:	should output overwrite an existing file
	 * Side Effects:	if successful, a new file is created at outputPath with serialized data
	 * Returns:	true if successful, else false
	 */
	public static boolean serialize(String inputPath, String outputPath, boolean overwrite) {
		
		File outputFile = new File(outputPath);
		
		//check if file already exists, and quit if we should not overwrite
		if (outputFile.exists()) {
			if (overwrite) {
				outputFile.delete();
			} else {
				return false;
			}
		}
		
		TreeSet<Word> words = new TreeSet<Word>();
		int lnCnt = 0;
		
		try (Scanner r = new Scanner(new File(inputPath))){
	
			//add words from file
			while(r.hasNext()) {
				lnCnt++;
				String line = r.nextLine();
				if (add(line, words) == false) {
					System.out.println("Line " + lnCnt + " \"" + line + "\" was unreadable");
					return false;
				}
			}
		} catch(IOException e) {
			System.out.println(e);
			return false;
		}
		
		try (FileOutputStream f_out = new FileOutputStream(outputPath); 
				ObjectOutputStream obj_out = new ObjectOutputStream(f_out)) {
			
			for (Word word : words) {
				obj_out.writeObject(word);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		} 
		return true;
	}
	
	/*
	 * Purpose:	add one word to the words set from an input line
	 * Parameters:	
	 * 				line:	String of form word|type
	 * 				words:	TreeSet to add word to
	 * Side Effects:	If true, a Word is added to words
	 * Returns:	true if successfully added a word, else false
	 */
	private static boolean add(String line, TreeSet<Word> words) {
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
}
