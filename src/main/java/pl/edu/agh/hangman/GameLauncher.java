package pl.edu.agh.hangman;

import static pl.edu.agh.hangman.Hangman.HANGMANPICS;

public class GameLauncher {

    public void playGame(String chosenWord) {
        String hashedWord;
        GameLogic gl = new GameLogic();

        while (true) {
            String letter = new CharScanner().getChar();
            gl.checkIfWordContainsChar(chosenWord, letter, HANGMANPICS);
            hashedWord = gl.getHashedWord(chosenWord, gl.getGuessedLetters());
            if (chosenWord.equals(hashedWord)) {
                System.out.println("You won");
                break;
            }
            if (gl.getTriesCount() == HANGMANPICS.length) {
                System.out.println("You lost. Word was: " + chosenWord);
                break;
            }
        }
    }
}
