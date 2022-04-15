package comp1721.cwk1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Game {
	private int gameNumber;
	private String target;
	private List<String> saveWords;
	
	// TODO: Implement constructor with String parameter
	public Game(String filename) throws IOException{
		super();
		WordList wordlist = new WordList(filename);
		LocalDate start = LocalDate.of(2021, 6, 19);
		LocalDate now = LocalDate.now();
		this.gameNumber = (int)(now.toEpochDay() - start.toEpochDay());
		this.target = wordlist.getWord(gameNumber);
	}

	// TODO: Implement constructor with int and String parameters
	public Game(int num, String filename) throws IOException{
		super();
		WordList wordlist = new WordList(filename);
		this.gameNumber = num;
		this.target = wordlist.getWord(gameNumber);
		
	}
	
	// TODO: Implement play() method
	public void play(){
		this.saveWords = new ArrayList<>();
		System.out.println("WORDLE " + this.gameNumber);
		System.out.println();
		System.out.print("Enter guess (1/6): ");
		Guess.readFromPlayer();
		Guess guess1 = new Guess(1, Guess.input);
		String str1 = guess1.compareWith(this.target);
		System.out.println(str1);
		this.saveWords.add(str1);
		if (guess1.matches(this.target)){
			System.out.println("Superb - Got it in one!");
			return;
		}
		
		System.out.print("Enter guess (2/6): ");
		Guess.readFromPlayer();
		Guess guess2 = new Guess(2, Guess.input);
		String str2 = guess2.compareWith(this.target);
		System.out.println(str2);
		this.saveWords.add(str2);
		if (guess2.matches(this.target)){
			System.out.println("Well done!");
			return;
		}
		
		System.out.print("Enter guess (3/6): ");
		Guess.readFromPlayer();
		Guess guess3 = new Guess(3, Guess.input);
		String str3 = guess3.compareWith(this.target);
		System.out.println(str3);
		this.saveWords.add(str3);
		if (guess3.matches(this.target)){
			System.out.println("Well done!");
			return;
		}
		
		System.out.print("Enter guess (4/6): ");
		Guess.readFromPlayer();
		Guess guess4 = new Guess(4, Guess.input);
		String str4 = guess4.compareWith(this.target);
		System.out.println(str4);
		this.saveWords.add(str4);
		if (guess4.matches(this.target)){
			System.out.println("Well done!");
			return;
		}
		
		System.out.print("Enter guess (5/6): ");
		Guess.readFromPlayer();
		Guess guess5 = new Guess(5, Guess.input);
		String str5 = guess5.compareWith(this.target);
		System.out.println(str5);
		this.saveWords.add(str5);
		if (guess5.matches(this.target)){
			System.out.println("Well done!");
			return;
		}
		
		System.out.print("Enter guess (6/6): ");
		Guess.readFromPlayer();
		Guess guess6 = new Guess(6, Guess.input);
		String str6 = guess6.compareWith(this.target);
		System.out.println(str6);
		this.saveWords.add(str6);
		if (guess6.matches(this.target)){
			System.out.println("That was a close call!");
			return;
		}else{
			System.out.println("Nope - Better luck next time!");
			System.out.println(this.target);
		}
	}  
	
	  // TODO: Implement save() method, with a String parameter
	public void save(String filename) throws IOException {
		 PrintWriter pw = new PrintWriter(new FileWriter(filename), true);
		 for(int i=0; i<this.saveWords.size(); i++){
			 pw.println(this.saveWords.get(i));
		 }
		 pw.close();
	}
}
