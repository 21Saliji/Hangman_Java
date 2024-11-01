package za.co.wethinkcode;

import java.util.List;
import java.util.Random;

public class WordSelector {
    private Random random = new Random();

    public  String selectRandomWord(List<String> words) {
        if (words.isEmpty()) {
            throw new IllegalArgumentException("List of words is empty.");
        }
        int randomIndex = random.nextInt(words.size());
        String randomWord = words.get(randomIndex);

        return randomWord;

    }

    public String maskWord(String randomWord) {
        int charIndex = random.nextInt(randomWord.length());
        StringBuilder maskedWord = new StringBuilder();

        for (int i = 0; i < randomWord.length(); i++) {
            if (i == charIndex) {
                maskedWord.append(randomWord.charAt(i));
            } else {
                maskedWord.append("_");
            }
        }

        return maskedWord.toString();
    }
}


