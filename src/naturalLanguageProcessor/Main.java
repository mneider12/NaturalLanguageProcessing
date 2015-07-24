package naturalLanguageProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			input = br.readLine();
		} catch(IOException e) {
			e.printStackTrace();
			return;
		}
		NLPagent agent = new NLPagent(input);
		System.out.println((agent.getFrames()));
	}
	
}
