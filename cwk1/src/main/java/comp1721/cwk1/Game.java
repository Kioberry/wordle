package comp1721.cwk1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Game {
	private int gameNumber;
	private String target;
	private List<String> saveWords;
	private boolean win;
	private int numGuess;
	
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
	
	//implement playa() method for people who have impaired colour vision
	public void playa(){
		this.saveWords = new ArrayList<>();
		System.out.println("WORDLE " + this.gameNumber);
		System.out.println();
		//≤‚ ‘
		System.out.println(this.target);
		System.out.print("Enter guess (1/6): ");
		Guess.readFromPlayer();
		Guess guess1 = new Guess(1, Guess.input);
		String str1 = guess1.compareWitha(this.target);
		System.out.println(str1);
		this.saveWords.add(str1);
		if (guess1.matches(this.target)){
			this.win = true;
			this.numGuess = 1;
			return;
		}
		
		System.out.print("Enter guess (2/6): ");
		Guess.readFromPlayer();
		Guess guess2 = new Guess(2, Guess.input);
		String str2 = guess2.compareWitha(this.target);
		System.out.println(str2);
		this.saveWords.add(str2);
		if (guess2.matches(this.target)){
			this.win = true;
			this.numGuess = 2;
			return;
		}
		
		System.out.print("Enter guess (3/6): ");
		Guess.readFromPlayer();
		Guess guess3 = new Guess(3, Guess.input);
		String str3 = guess3.compareWitha(this.target);
		System.out.println(str3);
		this.saveWords.add(str3);
		if (guess3.matches(this.target)){
			this.win = true;
			this.numGuess = 3;
			return;
		}
		
		System.out.print("Enter guess (4/6): ");
		Guess.readFromPlayer();
		Guess guess4 = new Guess(4, Guess.input);
		String str4 = guess4.compareWitha(this.target);
		System.out.println(str4);
		this.saveWords.add(str4);
		if (guess4.matches(this.target)){
			this.win = true;
			this.numGuess = 4;
			return;
		}
		
		System.out.print("Enter guess (5/6): ");
		Guess.readFromPlayer();
		Guess guess5 = new Guess(5, Guess.input);
		String str5 = guess5.compareWitha(this.target);
		System.out.println(str5);
		this.saveWords.add(str5);
		if (guess5.matches(this.target)){
			this.win = true;
			this.numGuess = 5;
			return;
		}
		
		System.out.print("Enter guess (6/6): ");
		Guess.readFromPlayer();
		Guess guess6 = new Guess(6, Guess.input);
		String str6 = guess6.compareWitha(this.target);
		System.out.println(str6);
		this.saveWords.add(str6);
		if (guess6.matches(this.target)){
			this.win = true;
			this.numGuess = 6;
			return;
		}else{
			this.win = false;
			this.numGuess = 6;
			System.out.println("Nope - Better luck next time!");
			System.out.println(this.target);
		}
	}
	
	
	
	// TODO: Implement play() method
	public void play(){
		this.saveWords = new ArrayList<>();
		System.out.println("WORDLE " + this.gameNumber);
		System.out.println();
		//≤‚ ‘
		System.out.println(this.target);
		System.out.print("Enter guess (1/6): ");
		Guess.readFromPlayer();
		Guess guess1 = new Guess(1, Guess.input);
		String str1 = guess1.compareWith(this.target);
		System.out.println(str1);
		this.saveWords.add(str1);
		if (guess1.matches(this.target)){
			System.out.println("Superb - Got it in one!");
			this.win = true;
			this.numGuess = 1;
			return;
		}
		
		System.out.print("Enter guess (2/6): ");
		Guess.readFromPlayer();
		Guess guess2 = new Guess(2, Guess.input);
		String str2 = guess2.compareWith(this.target);
		System.out.println(str2);
		this.saveWords.add(str2);
		if (guess2.matches(this.target)){
			this.win = true;
			this.numGuess = 2;
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
			this.win = true;
			this.numGuess = 3;
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
			this.win = true;
			this.numGuess = 4;
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
			this.win = true;
			this.numGuess = 5;
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
			this.win = true;
			this.numGuess = 6;
			System.out.println("That was a close call!");
			return;
		}else{
			this.win = false;
			this.numGuess = 6;
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
	
	//Store the outcome of each game in a specific file.
	public void saveHistory(String filename) throws IOException{
		File file = new File(filename);
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(this.gameNumber + "," + this.numGuess + "," + this.win);
		bw.newLine();
		bw.flush();
		bw.close();
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		int count = 0;
		
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		
		while ((str = br.readLine()) != null){
			String[] split = str.split(",");
			list1.add(split[0]);
			list2.add(split[1]);
			list3.add(split[2]);
		}
		//≤‚ ‘
		//System.out.println(list1);
		//System.out.println(list3);
		
		//Calcuate the number of wins
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String item : list3) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item).intValue() + 1);
			} else {
				map.put(item, new Integer(1));
			}
		}
		count = map.get("T").intValue();
		
		//calculate the percentage of games that were wins
		float per = (float)count/list3.size();
		DecimalFormat df = new DecimalFormat("0.00");
        String resultStr = df.format(per);
        float resultFloat = Float.parseFloat(resultStr);
        int percent = (int)(resultFloat * 100);
        System.out.println("The percentage of wins: " + percent + "%");
        
        //get Length of the current winning streak
        int Sindex = list3.lastIndexOf("F") + 1;
        int Eindex = list1.size()-1;   
        if (Sindex == Eindex){
        	System.out.println("Length of the current winning streak: 1 day");
        }
        else {
        	int start = Integer.parseInt(list1.get(Sindex));
            int end = Integer.parseInt(list1.get(Eindex));
            int conti = end - start + 1;
            System.out.println("Length of the current winning streak: " + conti + " days");
        }
        
        //Calculate Longest winning streak
        int Tcount = 0;
        int Tmax = 0;
        for(String s: list3){
        	if("T".equals(s)){
        		Tcount++;
        	}else if("F".equals(s)){
        		Tcount = 0;
        	}
        	
        	if(Tcount > Tmax){
        		Tmax = Tcount;
        	}
        }
        System.out.println("Longest winning streak: " + Tmax + " games");
        
        //Draw the Histogram of guess distribution
        
		br.close();
	}
	
}
