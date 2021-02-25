package hiperskill.projects.tictactoe;
import java.util.Scanner;

//          Coordinates
//        (1, 3) (2, 3) (3, 3)
//        (1, 2) (2, 2) (3, 2)
//        (1, 1) (2, 1) (3, 1)

public class Main {
    static boolean  gameIsStarted = false;
    static String input;

    public static void main(String[] args) throws CloneNotSupportedException {

        //Need to add exit during game
        PlayerFabric playerFabric = new PlayerFabric();
        Terminal terminal = new Terminal();

        mainLoop:
        while(true){
            input = "nothing";
            while (!input.equals("Correct parameters")) {
                input = Terminal.getCommand();
                if(input.equals("exit")) break mainLoop;
            }

            Field mainGameField = new Field();
            System.out.println(mainGameField);
            Player player1 = playerFabric.getNewPlayer(Terminal.command[1]);
            Player player2 = playerFabric.getNewPlayer(Terminal.command[2]);

            gameIsStarted = true;
            gameLoop:
            while(gameIsStarted) {
                player1.move(mainGameField);
                System.out.println(mainGameField);
                mainGameField.checkGameStatus();
                if (!gameIsStarted) break gameLoop;

                player2.move(mainGameField);
                System.out.println(mainGameField);
                mainGameField.checkGameStatus();
            }
        }
    }
}



