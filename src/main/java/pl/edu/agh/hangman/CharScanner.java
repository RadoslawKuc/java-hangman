package pl.edu.agh.hangman;


import java.util.Scanner;

public class CharScanner {

    public static void main(String[] args) {

        String scanner = new CharScanner().getChar();
    }

    public String getChar() {
        System.out.println("Please enter your char");
        Scanner scan = new Scanner(System.in);
        String userChar = scan.next();
        while (userChar.length() != 1) {
            System.out.println("Try again, enter only one character");
            userChar = scan.next();
        }

        System.out.println("This is your char " + userChar);
        return userChar;
    }
}
