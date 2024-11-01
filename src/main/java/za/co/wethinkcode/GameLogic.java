package za.co.wethinkcode;

public class GameLogic {
    private int remainingGuesses = 5;

    public void runGameLoop(String word) {
        String maskedWord = new WordSelector().maskWord(word);
        UserInput userInput = new UserInput();

        while (remainingGuesses > 0) {
            System.out.println("Guess the word:  " + maskedWord);
            String userInputString = userInput.getUserInput();

            if (userInputString.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing! Game ended.");
                return;
            }

            char guess = userInputString.charAt(0);
            if (isMissingChar(word, maskedWord, guess)) {
                maskedWord = fillCorrectLetters(word, maskedWord, guess);
                if (maskedWord.equals(word)) {
                    System.out.println("Congratulations! You've guessed the word: " + word);
                    return;
                }
            } else {
                remainingGuesses--;
                drawHangman(remainingGuesses);
                if (remainingGuesses == 0) {
                    System.out.println("Game Over! The word was: " + word);
                }
            }
        }
    }

    public boolean isMissingChar(String originalWord, String currentGuess, char guess) {
        return originalWord.contains(String.valueOf(guess)) && !currentGuess.contains(String.valueOf(guess));
    }

    public String fillCorrectLetters(String originalWord, String currentGuess, char guess) {
        StringBuilder newGuess = new StringBuilder(currentGuess);
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) == guess) {
                newGuess.setCharAt(i, guess);
            }
        }
        return newGuess.toString();
    }

    public void drawHangman(int remainingGuesses) {
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
        System.out.println("Wrong guess! Remaining guesses: " + remainingGuesses);
    }
}