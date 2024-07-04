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
        String filePath = "src/main/java/za/co/wethinkcode/" + fileName;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1); // Exit the program if file reading fails
        }
        return words;
    }



    // Step 2: Select random word from the list
    public static String selectRandomWord(ArrayList<String> words) {
        if (words.isEmpty()) {
            throw new IllegalArgumentException("List of words is empty.");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        String randomWord = words.get(randomIndex);

        // Replace a random character with "_"
        int charIndex = random.nextInt(randomWord.length());
        char randomChar = randomWord.charAt(charIndex);
        String displayWord = randomWord.substring(0, charIndex) + "_" + randomWord.substring(charIndex + 1);

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

    // Step 4: Show answer
    public static void showAnswer(char answer, String selectedWord, int missingLetterIndex) {
        char correctLetter = selectedWord.charAt(missingLetterIndex);

        if (answer != correctLetter) {
            System.out.println("The word was: " + selectedWord);
            System.out.println("Wrong! Do better next time.");
        } else {
            System.out.println("The word was: " + selectedWord);
            System.out.println("Well done! You are awesome!");
        }
    }

    // Helper method to ask for file name
    public static String askFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Words file? [leave empty to use ShortWords.txt] : ");
        String fileName = scanner.nextLine().trim();
        scanner.close();
        if (fileName.isEmpty()) {
            fileName = "ShortWords.txt"; // Default file name
        }
        return fileName;
    }



    // Main method to run the game
    public static void main(String[] args) {
        String fileName = askFileName();
        ArrayList<String> words = readWordsFromFile(fileName);

        if (words.isEmpty()) {
            System.out.println("No words found in the file.");
            return;
        }

        String selectedWord = selectRandomWord(words);
        char guessedChar = getUserInput();
        showAnswer(guessedChar, selectedWord, selectedWord.indexOf('_')); // Assuming '_' was randomly chosen
    }
}
