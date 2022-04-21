package comp1721.cwk1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;


public class Game{
	private int gameNumber;
	private String target;
	private List<String> saveWords;
	private String win;
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
	
	//TODO: implement playa() method for people who have impaired color vision
	public void playa(){
		this.saveWords = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("WORDLE " + this.gameNumber);
		System.out.println();
		//测试
		//System.out.println(this.target);
		System.out.print("Enter guess (1/6): ");
		Guess guess1 = new Guess(1, input.nextLine());
		String str1 = guess1.compareWitha(this.target);
		System.out.println(str1);
		this.saveWords.add(str1);
		if (guess1.matches(this.target)){
			this.win = "T";
			this.numGuess = 1;
			return;
		}
		
		System.out.print("Enter guess (2/6): ");
		Guess guess2 = new Guess(2, input.nextLine());
		String str2 = guess2.compareWitha(this.target);
		System.out.println(str2);
		this.saveWords.add(str2);
		if (guess2.matches(this.target)){
			this.win = "T";
			this.numGuess = 2;
			return;
		}
		
		System.out.print("Enter guess (3/6): ");
		Guess guess3 = new Guess(3, input.nextLine());
		String str3 = guess3.compareWitha(this.target);
		System.out.println(str3);
		this.saveWords.add(str3);
		if (guess3.matches(this.target)){
			this.win = "T";
			this.numGuess = 3;
			return;
		}
		
		System.out.print("Enter guess (4/6): ");
		Guess guess4 = new Guess(4, input.nextLine());
		String str4 = guess4.compareWitha(this.target);
		System.out.println(str4);
		this.saveWords.add(str4);
		if (guess4.matches(this.target)){
			this.win = "T";
			this.numGuess = 4;
			return;
		}
		
		System.out.print("Enter guess (5/6): ");
		Guess guess5 = new Guess(5, input.nextLine());
		String str5 = guess5.compareWitha(this.target);
		System.out.println(str5);
		this.saveWords.add(str5);
		if (guess5.matches(this.target)){
			this.win = "T";
			this.numGuess = 5;
			return;
		}
		
		System.out.print("Enter guess (6/6): ");
		Guess guess6 = new Guess(6, input.nextLine());
		String str6 = guess6.compareWitha(this.target);
		System.out.println(str6);
		this.saveWords.add(str6);
		if (guess6.matches(this.target)){
			this.win = "T";
			this.numGuess = 6;
			return;
		}else{
			this.win = "F";
			this.numGuess = 6;
			System.out.println("Nope - Better luck next time!");
			System.out.println(this.target);
		}
	}
	
	
	
	// TODO: Implement play() method
	public void play(){
		this.saveWords = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("WORDLE " + this.gameNumber);
		System.out.println();
		//测试
		//System.out.println(this.target);
		System.out.print("Enter guess (1/6): ");
		Guess guess1 = new Guess(1, input.nextLine());
		String str1 = guess1.compareWith(this.target);
		System.out.println(str1);
		this.saveWords.add(str1);
		if (guess1.matches(this.target)){
			System.out.println("Superb - Got it in one!");
			this.win = "T";
			this.numGuess = 1;
			return;
		}
		
		System.out.print("Enter guess (2/6): ");
		Guess guess2 = new Guess(2, input.nextLine());
		String str2 = guess2.compareWith(this.target);
		System.out.println(str2);
		this.saveWords.add(str2);
		if (guess2.matches(this.target)){
			this.win = "T";
			this.numGuess = 2;
			System.out.println("Well done!");
			return;
		}
		
		System.out.print("Enter guess (3/6): ");
		Guess guess3 = new Guess(3, input.nextLine());
		String str3 = guess3.compareWith(this.target);
		System.out.println(str3);
		this.saveWords.add(str3);
		if (guess3.matches(this.target)){
			this.win = "T";
			this.numGuess = 3;
			System.out.println("Well done!");
			return;
		}
		
		System.out.print("Enter guess (4/6): ");
		Guess guess4 = new Guess(4, input.nextLine());
		String str4 = guess4.compareWith(this.target);
		System.out.println(str4);
		this.saveWords.add(str4);
		if (guess4.matches(this.target)){
			this.win = "T";
			this.numGuess = 4;
			System.out.println("Well done!");
			return;
		}
		
		System.out.print("Enter guess (5/6): ");
		Guess guess5 = new Guess(5, input.nextLine());
		String str5 = guess5.compareWith(this.target);
		System.out.println(str5);
		this.saveWords.add(str5);
		if (guess5.matches(this.target)){
			this.win = "T";
			this.numGuess = 5;
			System.out.println("Well done!");
			return;
		}
		
		System.out.print("Enter guess (6/6): ");
		Guess guess6 = new Guess(6, input.nextLine());
		String str6 = guess6.compareWith(this.target);
		System.out.println(str6);
		this.saveWords.add(str6);
		if (guess6.matches(this.target)){
			this.win = "T";
			this.numGuess = 6;
			System.out.println("That was a close call!");
			return;
		}else{
			this.win = "F";
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
	
	// TODO: Store the outcome of each game in a specific file.
	public void saveHistory(String filename) throws IOException{
		File file = new File(filename);
		// Check whether the file exists, create one if it doesn't exist
		if(!file.exists())    
	    {    
	        try {    
	            file.createNewFile();    
	        } catch (IOException e) {    
	            // TODO Auto-generated catch block    
	            e.printStackTrace();    
	        }    
	    }    
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
		
		// Store the contents of the file into Lists
		while ((str = br.readLine()) != null){
			String[] split = str.split(",");
			list1.add(split[0]);
			list2.add(split[1]);
			list3.add(split[2]);
		}
		
		// Calculate the number of wins
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String item : list3) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item).intValue() + 1);
			} else {
				map.put(item, new Integer(1));
			}
		}
		count = map.get("T").intValue();
		
		// calculate the percentage of games that were wins
		float per = (float)count/list3.size();
		DecimalFormat df = new DecimalFormat("0.00");
        String resultStr = df.format(per);
        float resultFloat = Float.parseFloat(resultStr);
        int percent = (int)(resultFloat * 100);
        // TODO: display the percentage of wins
        System.out.println("The percentage of wins: " + percent + "%");
        
        // get Length of the current winning streak
        int Sindex = list3.lastIndexOf("F");
        int Eindex = list1.size()-1; 
        boolean Fcontain = list3.contains("F");
        int conti = 0;
        int start = 0;
        int end = 0;
        if (Fcontain == false){
        	start = Integer.parseInt(list1.get(0));
        	end = Integer.parseInt(list1.get(Eindex));
        	conti = end - start + 1;
        	if (conti == 1 || conti <= 0){
        		System.out.println("Length of the current winning streak: 1 day");
        	}else{
        		System.out.println("Length of the current winning streak: " + conti + " days");
        	}
        }else if (Sindex == Eindex){
        	System.out.println("Length of the current winning streak: 0 day");
        }else {
        	start = Integer.parseInt(list1.get(Sindex + 1));
            end = Integer.parseInt(list1.get(Eindex));
            conti = end - start + 1;
            if (conti == 1 || conti <= 0){
            	System.out.println("Length of the current winning streak: 1 day");
            }else {
            	System.out.println("Length of the current winning streak: " + conti + " days");
            }
        }
        
        // Calculate Longest winning streak
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
        // TODO: display the Longest winning streak
        System.out.println("Longest winning streak: " + Tmax + " games");
        
        // Draw the Histogram of guess distribution
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("1", 0);
        map1.put("2", 0);
        map1.put("3", 0);
        map1.put("4", 0);
        map1.put("5", 0);
        map1.put("6", 0);
		for (String item : list2) {
			if (map1.containsKey(item)) {
				map1.put(item, map1.get(item).intValue() + 1);
			} else {
				map1.put(item, new Integer(1));
			}
		}
		
		List<Integer> gusList = new LinkedList<Integer>();
        Collection<Integer> values =  map1.values();
        Iterator<Integer> it2 = values.iterator();
        while(it2.hasNext()) {
            gusList.add(it2.next());
        }
        
        // Create a new jframe
        JFrame frame2 = new JFrame();
        HistogramPanel histogrampanel = new HistogramPanel(gusList);
        // Add a panel
        frame2.getContentPane().add(histogrampanel);
        // Set the title of the jFrame
        frame2.setTitle("Histogram");
        // Set the size of the JFrame
        frame2.setSize(800, 600);
        // Display the panel on the JFrame
        frame2.setVisible(true);
        // Display it in the center
        frame2.setLocationRelativeTo(null);
        // Close the whole program while closing the JFrame
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		br.close();
	}
	
}
