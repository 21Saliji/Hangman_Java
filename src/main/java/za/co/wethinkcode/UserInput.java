package za.co.wethinkcode;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String getUserInput(){
        System.out.print("Guess the missing letter (or type 'exit' to quit): ");
        return scanner.nextLine().trim();
    }

}
