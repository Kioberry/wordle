package comp1721.cwk1;


import java.io.IOException;


public class Wordle {
  public static void main(String[] args) throws IOException {
    Game game;

    String str = "-a";
    if (args.length > 0) {
      //judge whether the args[0] is about people who are visually impaired
      if (args[0].equals(str)){
    	  if (args.length == 2){
    		  game = new Game(Integer.parseInt(args[1]), "data/words.txt");
    		  game.playa();
    	  }
    	  else {
    		  game = new Game("data/words.txt");
    		  game.playa();
    	  }
      }
      else{
    	  // Player wants to specify the game
          game = new Game(Integer.parseInt(args[0]), "data/words.txt");
          game.play();
      }
      
   }
   else {
     // Play today's game
     game = new Game("data/words.txt");
     game.play();
   }

   game.save("build/lastgame.txt");
   game.saveHistory("build/history.txt");
  }
}
