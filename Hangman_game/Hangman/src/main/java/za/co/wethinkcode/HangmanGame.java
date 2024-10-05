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

    // Step 2: Select random word from the list and replace a random character with "_"
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

    // Step 4: Check if character is missing in the original word
    public static boolean isMissingChar(String originalWord, String answerWord, char guess) {
        return originalWord.contains(String.valueOf(guess)) && !answerWord.contains(String.valueOf(guess));
    }

    // Step 5: Fill in correct character in the answer word
    public static String doCorrectAnswer(String originalWord, String answer, char guess) {
        StringBuilder sb = new StringBuilder(answer);
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) == guess) {
                sb.setCharAt(i, guess);
            }
        }
        return sb.toString();
    }

    // Step 6: Handle wrong answer and draw hangman figure
    public static void doWrongAnswer(int remainingGuesses) {
        switch (remainingGuesses) {
            case 4:
                System.out.println("/----");
                break;
            case 3:
                System.out.println("/----");
                System.out.println("|   0");
                break;
            case 2:
                System.out.println("/----");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                break;
            case 1:
                System.out.println("/----");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|   |");
                break;
            case 0:
                System.out.println("/----");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|   |");
                System.out.println("|  / \\");
                break;
        }
        System.out.println("Wrong! Number of guesses left: " + remainingGuesses);
    }

    // Step 7: Main game loop
    public static void runGameLoop(String word) {
        int remainingGuesses = 5;
        String answer = randomFillWord(word);

        while (true) {
            System.out.println("Current guess: " + answer);

            char guess = getUserInput();
            if (guess == '0') {
                break;
            }

            if (isMissingChar(word, answer, guess)) {
                answer = doCorrectAnswer(word, answer, guess);
                if (word.equals(answer)) {
                    System.out.println("Congratulations! You've guessed the word: " + word);
                    break;
                }
            } else {
                remainingGuesses--;
                doWrongAnswer(remainingGuesses);
                if (remainingGuesses == 0) {
                    System.out.println("Sorry, you are out of guesses. The word was: " + word);
                    break;
                }
            }
        }
    }

    // Helper method to fill in random characters except one
    public static String randomFillWord(String word) {
        Random random = new Random();
        int charIndex = random.nextInt(word.length());
        char randomChar = word.charAt(charIndex);
        StringBuilder sb = new StringBuilder(word.length());
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == randomChar) {
                sb.append(randomChar);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

  
    // Main method to start the game
    public static void main(String[] args) {
        String fileName = "ShortWords.txt";
        ArrayList<String> words = readWordsFromFile(fileName);

        if (words.isEmpty()) {
            System.out.println("No words found in the file.");
            return;
        }

        String selectedWord = selectRandomWord(words);
        runGameLoop(selectedWord);
    }
}
