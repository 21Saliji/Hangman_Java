package za.co.wethinkcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    // Step 1: Read file and return list of words
    public static ArrayList<String> readWordsFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    // Step 2: Select random word from the list
    public static String selectRandomWord(ArrayList<String> words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        String randomWord = words.get(randomIndex);

        // Replace a random character with "_"
        int charIndex = random.nextInt(randomWord.length());
        char randomChar = randomWord.charAt(charIndex);
        String displayWord = randomWord.replace(randomChar, '_');

        System.out.println("Guess the word: " + displayWord);
        return randomWord;
    }

    // Step 3: Get user input for the guessed letter
    public static char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nGuess the missing letter: ");
        String input = scanner.nextLine().trim();
        scanner.close();
        return input.charAt(0);
    }

    // Main method to run the game
    public static void main(String[] args) {
        String fileName = "ShortWords.txt";
        ArrayList<String> words = readWordsFromFile(fileName);
        String selectedWord = selectRandomWord(words);
        char guessedChar = getUserInput();
        System.out.println("The word was: " + selectedWord);
    }
}
