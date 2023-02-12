package pl.edu.agh.hangman;

public class Hangman {

    public static void main(String[] args) {
        WordGenerator wg = new WordGenerator();
        String choosenWord = wg.getWord();

        System.out.println(choosenWord);

        GameLogic gl = new GameLogic();
        String hashedWord = choosenWord.replaceAll("[^*]", "_");
        System.out.println(hashedWord);
        while(!choosenWord.equals(hashedWord) || gl.triesCount == HANGMANPICS.length){
            String letter = new CharScanner().getChar();
            gl.checkIfWordContainsChar(choosenWord, letter, HANGMANPICS);
            hashedWord = gl.getHashedWord(choosenWord, gl.getGuessedLetters());
            if (choosenWord.equals(hashedWord)) System.out.println("you won");
            if (gl.triesCount == HANGMANPICS.length){
                System.out.println("you lost");
                break;
            }
        }
    }


    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

}
