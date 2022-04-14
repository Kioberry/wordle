package comp1721.cwk1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordList {
	private List<String> words;

	// TODO: Implement constructor with a String parameter
	public WordList(String filename) throws IOException {
		super();
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		words = new ArrayList<>();
		String str = null;
		while ((str = br.readLine()) != null) {
			if(str.trim().length() == 5){
				words.add(str);
			}
        }	
	}
	
  // TODO: Implement size() method, returning an int
	public int size(){
		return words.size();
	}
	
  // TODO: Implement getWord() with an int parameter, returning a String
	public String getWord(int n) throws GameException {
		if (n >= 0 && n < this.size()){
			return words.get(n);
		}else{
			throw new GameException("Invalid input of game number.");
		}
		
	}

	
}