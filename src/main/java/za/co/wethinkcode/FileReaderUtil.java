package za.co.wethinkcode;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
//        String filePath = "src/main/java/za/co/wethinkcode/" + fileName;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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
}
