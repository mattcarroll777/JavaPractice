import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Hangman {
  private static final String answerWord = "hello world";
  private static final int maxGuesses = 6;
  private int mistakeCounter = 0;
  private Set<Character> guessedLetters = new HashSet<>();

  public void playGame(){
    Scanner scanner = new Scanner(System.in);

    while(mistakeCounter < maxGuesses){
      printCurrentState();
      System.out.println("Guess:");
      String line = scanner.nextLine();
      if(line.length() == 1){
        processGuess(line.charAt(0));
      }else{
        System.out.println("One Letter Please");
      }
      if (isGameWon()){
        System.out.println("Congrats!!");
        printCurrentState();
        return;
      }
    }

    System.out.println("Game Over! Answer is: " + answerWord);
  }

  private void processGuess(char guess){
    if(guessedLetters.contains(guess) || !Character.isLetter(guess)){
      System.out.println("Letter already guessed.");
      return;
    }
    guessedLetters.add(guess);

    if(answerWord.indexOf(guess)<0){
      mistakeCounter++;
      System.out.println("Nope!");
    }
  }

  private boolean isGameWon(){
    for(char letter : answerWord.toCharArray()){
      if(!guessedLetters.contains(letter)){
        return false;
      }
    }
    return true;
  }

  private void printCurrentState(){
    for (char letter : answerWord.toCharArray()){
      if(guessedLetters.contains(letter)){
        System.out.print(letter + " ");
      } else {
        System.out.print("_ ");
      }
    }
    System.out.println("\nMistakes made: " + mistakeCounter + "/" + maxGuesses);
  }
  public static void main(String[] args){
    Hangman game = new Hangman();
    game.playGame();
  }
}