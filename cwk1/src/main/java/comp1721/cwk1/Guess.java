package comp1721.cwk1;

import java.util.Scanner;


public class Guess {
	private int guessNumber;
	private String chosenWord;
  
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
  public void readFromPlayer(){
	  
  }

  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target){
	  char[] playArr = target.toCharArray();
	  char[] gameArr = this.chosenWord.toCharArray();
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
		  }
		  if (isFlag == 0){
			  //System.out.print(" 白 " + playArr[i]);
			  System.out.printf("\033[30;107m %c \033[0m", playArr[i]);
		  }
		  if (isFlag == 1){
			  //System.out.print(" 绿 " + playArr[i]);
			  System.out.printf("\033[30;102m %c \033[0m", playArr[i]);
		  }
		  if (isFlag == 2){
			  //System.out.print(" 黄 " + playArr[i]);
			  System.out.printf("\033[30;103m %c \033[0m", playArr[i]);
		  }
		  i++;	
		  isFlag = 0;
	  }
	  System.out.println();  
	  return target;
  }
  
  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target){
	  char[] playArr = target.toCharArray();
	  char[] gameArr = this.chosenWord.toCharArray();
	  for (int i=0; i<playArr.length; i++){
		  if (playArr[i] != gameArr[i]){
			  return false;
		  }
	  }
	  return true;
  }
}
