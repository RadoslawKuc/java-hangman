package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordGenerator {
    public static void main(String[] args) {
        WordGenerator wg = new WordGenerator();
        System.out.println(wg.getWord());
    }

    private List<String> getWordsFromFile()  {
        List<String> words = new ArrayList<>();

        try {
            URL resource = getClass().getClassLoader().getResource("slowa.txt");
            File file = new File(resource.toURI());
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                words.add(word.toLowerCase());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    public String getWord(){
        List<String> wordsList = getWordsFromFile();
        String yourWord;
        int seed = (int) (Math.random() * (wordsList.size()) + 0);
        yourWord = wordsList.get(seed);
        return yourWord;
    }
}
