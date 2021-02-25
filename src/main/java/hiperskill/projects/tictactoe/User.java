package hiperskill.projects.tictactoe;

import java.util.Scanner;

public class User extends Player{

    @Override
    void move(Field field) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        String inputLine;
        String[] move;
        int x = 0, y = 0;

        while(true) {
            inputLine = scanner.nextLine();
            if (inputLine.length() != 3) {
                System.out.println("You should enter numbers!");
                continue;
            }

            move = inputLine.split("\\s");
            try {
                x = Integer.parseInt(move[0]);
                y = Integer.parseInt(move[1]);

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (field.isOccupied(x, y)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                if(myMoveIsOorX(field).equals("X")) field.setCell_X(x,y);
                else field.setCell_O(x,y);
                break;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }

    }
}
