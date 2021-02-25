package hiperskill.projects.tictactoe;

import java.util.Scanner;

public class Terminal {
    static String line;
    static String[] command;

    static String getCommand() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input command:");
        line = sc.nextLine();
        command = line.split("\\s");
        if(command[0].equals("exit")) {
            return "exit";
        } else if (command.length == 3 && command[0].equals("start")
                && (command[1].equals("user") || command[1].equals("easy")|| command[1].equals("medium")|| command[1].equals("hard"))
                && (command[2].equals("user") || command[2].equals("easy")|| command[2].equals("medium")|| command[2].equals("hard"))) {
            return "Correct parameters";
        } else {
            System.out.println("Bad parameters!");
            return "Bad parameters!";
        }

    }
}
