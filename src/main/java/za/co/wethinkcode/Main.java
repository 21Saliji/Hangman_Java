package za.co.wethinkcode;

import java.util.List;

import static za.co.wethinkcode.FileReaderUtil.readWordsFromFile;


public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/ShortWords.txt";
        List<String> words = readWordsFromFile(filePath);

        WordSelector wordSelector = new WordSelector();
        String randomWord = wordSelector.selectRandomWord(words);
        GameLogic gameLogic = new GameLogic();
        gameLogic.runGameLoop(randomWord);
//        System.out.println(randomWord);
        }

}