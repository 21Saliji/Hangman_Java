package za.co.wethinkcode;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public char getUserInput(){
        System.out.print("Guess the missing letter: ");
        return scanner.nextLine().trim().charAt(0);
    }

}
