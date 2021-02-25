package hiperskill.projects.tictactoe;

import java.util.Random;

public class Easy extends Player{
    @Override
    void move(Field field) {
        Random rand = new Random(System.currentTimeMillis());
        int x, y;
        System.out.println("Making move level \"easy\"" + "my move is " + myMoveIsOorX(field));
        do {
            x = rand.nextInt(3) + 1;
            y = rand.nextInt(3) + 1;
        } while (field.isOccupied(x,y));

        if(myMoveIsOorX(field).equals("X")) field.setCell_X(x,y);
        else field.setCell_O(x,y);
    }
}
