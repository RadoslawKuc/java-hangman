package pl.edu.agh.hangman;

public class GameLogic {
    String guessedLetters;
    int triesCount;
    public String getGuessedLetters() {
        return guessedLetters;
    }

    public static void main(String[] args) {
    }

    public void checkIfWordContainsChar(String word, String letter, String[] hangmanTemplate){

        if (word.contains(letter)){
            guessedLetters = guessedLetters + letter;
        } else {
            System.out.println("this word does not contain your letter. Remaining tries " + (hangmanTemplate.length - triesCount));

            this.triesCount++;
        }
    }

    public static String getHashedWord(String word, String guessedLetters){
        String hashedWord = word.replaceAll("[^" + guessedLetters + "]", "_");
        System.out.println(hashedWord);
        return hashedWord;
    }
}
