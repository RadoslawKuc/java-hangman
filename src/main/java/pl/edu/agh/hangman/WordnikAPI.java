package pl.edu.agh.hangman;


import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WordnikAPI {

    public static void main(String[] args)  {
    }

    public String getWord()  {
        URL url;
        try {
            url = new URL("https://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine = in.readLine().replace("[", "").replace("]", "");
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(inputLine);
        Object word = json.get("word");
        return word.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
