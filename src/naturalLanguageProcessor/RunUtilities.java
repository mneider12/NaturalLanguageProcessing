package naturalLanguageProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RunUtilities {

	public static void main(String[] args){
		
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("Serialize");
		Menu menu = new Menu(choices);
		String choice = menu.promptChoices();
		switch (choice) {
		case "Serialize":
			try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in))){
			    
			    System.out.println("Enter input path: "); 
			    String inputPath = r.readLine();
			    
			    System.out.println("Enter output path: ");
			    String outputPath = r.readLine();
			    
			    if (Utilities.serialize(inputPath, outputPath, false)) {
			    	System.out.println("Successfully created " + outputPath);
			    } else {
			    	System.out.println("Failed to create " + outputPath);
			    }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
