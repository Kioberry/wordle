package comp1721.cwk1;

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
			  //System.out.print(" °× " + playArr[i]);
			  String str3 = "\033[30;107m " + playArr[i] + " \033[0m";
			  //System.out.print(str3);
			  sb.append(str3);
		  }
		  if (isFlag == 1){
			  //System.out.print(" ÂÌ " + playArr[i]);
			  String str1 = "\033[30;102m " + playArr[i] +" \033[0m";
			  //System.out.print(str1);
			  sb.append(str1);
		  }
		  if (isFlag == 2){
			  //System.out.print(" »Æ " + playArr[i]);
			  String str2 = "\033[30;103m " + playArr[i] + " \033[0m";
			  //System.out.print(str2);
			  sb.append(str2);
		  }
		  i++;	
		  isFlag = 0;
	  }
	  System.out.println();  
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
