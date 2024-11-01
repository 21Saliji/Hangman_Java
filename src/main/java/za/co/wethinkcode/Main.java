package za.co.wethinkcode;

import java.util.List;

import static za.co.wethinkcode.FileReaderUtil.readWordsFromFile;


public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/ShortWords.txt";
        List<String> words = readWordsFromFile(filePath);

        WordSelector wordSelector = new WordSelector();
        UserInput userInput = new UserInput();

        String randomWord = wordSelector.selectRandomWord(words);
        String maskedWord = wordSelector.maskWord(randomWord);
        int remainingGuesses = 5;
        while (remainingGuesses > 0) {
            char guess = userInput.getUserInput();
        }
//        System.out.println(randomWord);
        }

}