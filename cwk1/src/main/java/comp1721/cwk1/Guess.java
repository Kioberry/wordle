package comp1721.cwk1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Guess {
	private int guessNumber;
	private String chosenWord;
	public static String input;
  
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);
  
  // TODO: Implement constructor with int parameter
  public Guess(int num) throws GameException {
	  super();
	  if (num >= 1 && num <= 6){  
		  this.guessNumber = num;
	  }else{
		  throw new GameException("Invalid guessNumber");
	  }
  }

  //TODO: Implement constructor with int and String parameters
  public Guess(int num, String word) throws GameException {
	  super();	
	  boolean isDigit = false;
	  for(int i=0 ; i<word.length() ; i++){ 
          if(Character.isDigit(word.charAt(i))){     
              isDigit = true;   
          }
		}
	  
	  if (num >= 1 && num <= 6 && word.length() == 5 && isDigit == false){
		  this.guessNumber = num;
		  String word1 = word.toUpperCase();
		  this.chosenWord = word1;
	  }else {
		  throw new GameException("Invalid input of number or word");
	  }
	
  }

  //TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber() {
	  return guessNumber;
  }


  //TODO: Implement getChosenWord(), returning a String
  public String getChosenWord() {
	  return chosenWord;
  }


  // TODO: Implement readFromPlayer()
  public static void readFromPlayer(){
	  input = INPUT.nextLine();
  }
  
  public String compareWitha(String target){
	  char[] playArr = this.chosenWord.toCharArray();
	  char[] gameArr = target.toCharArray();
	  
	  List<String> gword = new ArrayList<>();
	  List<String> yword = new ArrayList<>();
	  StringBuilder sb = new StringBuilder();
	  
	  int isFlag = 0;
	  int i = 0;
	  while(i<playArr.length){
		  for (int j=0; j<gameArr.length; j++){
			  if (i == j && playArr[i] == gameArr[j]){
				  isFlag = 1;
			  }
			  else if (i != j && playArr[i] == gameArr[j]){
				  isFlag = 2;
			  }
			  for (int m=0; m<i; m++){
				  if (playArr[m] == playArr[i]){
					  isFlag = 0;
					  break;
				  }
			  }
		  }
		  if (isFlag == 1){//green
			  String str1 = null;
			  if (i == 1){
				  str1 = "2nd";
				  gword.add(str1);
			  }
			  if (i == 2){
				  str1 = "3rd";
				  gword.add(str1);
			  }
			  if (i == 0 || i == 3 || i == 4){
				  str1 = (i+1) + "st";
				  gword.add(str1);
			  }
		  }
		  if (isFlag == 2){//yellow
			  String str2 = null;
			  if (i == 1){
				  str2 = "2nd";
				  yword.add(str2);
			  }
			  if (i == 2){
				  str2 = "3rd";
				  yword.add(str2);
			  }
			  if (i == 0 || i == 3 || i == 4){
				  str2 = (i+1) + "st";
				  yword.add(str2);
			  }
		  }
		  i++;	
		  isFlag = 0;
	  }
	  
	  String str = null;
	  String str3 = null;
	  String str4 = null;
	  if (gword.size() == 0 && yword.size() == 0){
		  sb.append("No letter is correct");
		  str = sb.toString();
		  return str;
	  }
	  if (gword.size() == 5){
		  sb.append("You won!");
		  str = sb.toString();
		  return str;
	  }
	  if (yword.size() == 5){
		  sb.append("All letters are correct but in wrong place");
		  str = sb.toString();
		  return str;
	  }
	  else{
		  if (gword.size() == 1){
			  str3 = gword.get(0) + " perfect";
		  }else if(gword.size() == 2){
			  str3 = gword.get(0) + " and " + gword.get(1) + " perfect";
		  }else if(gword.size() == 3){
			  str3 = gword.get(0) + ", " + gword.get(1) + " and " + gword.get(2) + " perfect";
		  }else if(gword.size() == 4){
			  str3 = gword.get(0) + ", " + gword.get(1) + ", " + gword.get(2) + " and " + gword.get(3) + " perfect";
		  }
		  
		  
		  if (yword.size() == 1){
			  str4 = yword.get(0) + " correct but in wrong place";
		  }else if(yword.size() == 2){
			  str4 = yword.get(0) + " and " + yword.get(1) + " correct but in wrong place";
		  }else if(yword.size() == 3){
			  str4 = yword.get(0) + ", " + yword.get(1) + " and " + yword.get(2) + " correct but in wrong place";
		  }else if(yword.size() == 4){
			  str4 = yword.get(0) + ", " + yword.get(1) + ", " + yword.get(2) + " and " + yword.get(3) + " correct but in wrong place";
		  }
		  
	  }
	  
	  
	  if (str3 == null){
		  sb.append(str4);
	  }
	  else if (str4 == null){
		  sb.append(str3);
	  }
	  else{
		  String s1 = str4 + ", " + str3;
		  sb.append(s1);
	  }
	  str = sb.toString();
	  return str;
	  
	  
	  
	  
	 
  }
  
  
  
  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target){
	  char[] playArr = this.chosenWord.toCharArray();
	  char[] gameArr = target.toCharArray();
	  StringBuilder sb = new StringBuilder();
	  int isFlag = 0;
	  int i = 0;
	  while(i<playArr.length){
		  for (int j=0; j<gameArr.length; j++){
			  if (i == j && playArr[i] == gameArr[j]){
				  isFlag = 1;
			  }
			  else if (i != j && playArr[i] == gameArr[j]){
				  isFlag = 2;
			  }
			  for (int m=0; m<i; m++){
				  if (playArr[m] == playArr[i]){
					  isFlag = 0;
					  break;
				  }
			  }
		  }
		  if (isFlag == 0){
			  String str3 = "\033[30;107m " + playArr[i] + " \033[0m";
			  sb.append(str3);
		  }
		  if (isFlag == 1){
			  String str1 = "\033[30;102m " + playArr[i] +" \033[0m";
			  sb.append(str1);
		  }
		  if (isFlag == 2){
			  String str2 = "\033[30;103m " + playArr[i] + " \033[0m";
			  sb.append(str2);
		  }
		  i++;	
		  isFlag = 0;
	  }
	  //System.out.println();  
	  String str = sb.toString();
	  return str;
  }
  
  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target){
	  char[] playArr = this.chosenWord.toCharArray();
	  char[] gameArr = target.toCharArray();
	  for (int i=0; i<playArr.length; i++){
		  if (playArr[i] != gameArr[i]){
			  return false;
		  }
	  }
	  return true;
  }
}
