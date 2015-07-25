package naturalLanguageProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
	
	private ArrayList<String> choices;

	public Menu(ArrayList<String> choices) {
		
		this.choices = choices;
	}
	
	public String promptChoices() {
		int size = choices.size();
		for (int i = 0; i < size; i++) {
			System.out.println(i + ". " + choices.get(i));
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			input = br.readLine();
			return choices.get(Integer.parseInt(input));
		} catch(IOException e) {
			e.printStackTrace();
			return "";
		} catch(NumberFormatException e) {
			return "";
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
		
	}
}
