package pl.edu.agh.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class WordGenerator {
    List<String> wordsList;
    String yourWord;
    public static void main(String[] args) {
        WordGenerator wg = new WordGenerator();
        System.out.println(wg.getWord());
    }

    private List<String> getWordsList(){
        List<String> lines;
        Path path = Paths.get("src/main/resources/slowa.txt");
        try {
             lines = Files.lines(path)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public String getWord(){
        wordsList = getWordsList();
        int seed = (int) (Math.random() * (wordsList.size()) + 0);
        yourWord = wordsList.get(seed);
        return yourWord;
    }

    public String getWord(int numberOfLetters){
        wordsList = getWordsList()
                .stream().filter(word -> word.length() == numberOfLetters ).collect(Collectors.toList());
        int seed = (int) (Math.random() * (wordsList.size()) + 0);
        yourWord = wordsList.get(seed);
        return yourWord;
    }

}
