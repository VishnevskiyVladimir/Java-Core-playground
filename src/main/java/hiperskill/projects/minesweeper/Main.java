package hiperskill.projects.minesweeper;
import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

    //=============Field Generation =========================
        System.out.print("How many mines do you want on the field? ");
        int n = sc.nextInt();
        Field field = new Field(n);
        System.out.println(field);
        System.out.print("Set/unset mines marks or claim a cell as free: ");

        int firstX = sc.nextInt() -1, firstY = sc.nextInt() - 1;
        sc.nextLine();

        field.generateCells(n, firstX, firstY);

    //============= Game itself =========================

        while(field.getGameStatus() == 0){
            System.out.print(field);
            field.userMove();

        }

        System.out.print(field);
        System.out.println(field.getGameStatus() == 2 ? "Congratulations! You found all mines!" : "You stepped on a mine and failed!");
    }

}

