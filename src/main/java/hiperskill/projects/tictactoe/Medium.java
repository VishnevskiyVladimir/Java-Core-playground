package hiperskill.projects.tictactoe;

import java.util.Random;

public class Medium extends Player {
   private int WinX = 0;
   private int WinY = 0;


    @Override
    void move(Field field) {
        System.out.println("Making move level \"medium\"" + "my move is " + myMoveIsOorX(field));
        if(iCanWinNextMove(field)){
            if(myMoveIsOorX(field).equals("X")) field.setCell_X(WinX,WinY);
            else field.setCell_O(WinX,WinY);
            //System.out.println("Выигрышное поле для " + myMoveIsOorX(field) + " " + WinX + " " + WinY);
        } else if(opponentCanWinNextMove(field)){
            //System.out.println("Выигрышное поле для " + opponentMoveIsOorX(field) + " " + WinX + " " + WinY);
            if(myMoveIsOorX(field).equals("X")) field.setCell_X(WinX,WinY);
            else field.setCell_O(WinX,WinY);
        } else {
            Random rand = new Random(System.currentTimeMillis());
            int x, y;

            do {
                x = rand.nextInt(3) + 1;
                y = rand.nextInt(3) + 1;
            } while (field.isOccupied(x,y));

            if(myMoveIsOorX(field).equals("X")) field.setCell_X(x,y);
            else field.setCell_O(x,y);
        }

    }


    private boolean iCanWinNextMove(Field field) {
       return canWin(field,myMoveIsOorX(field));
    }
    private boolean opponentCanWinNextMove(Field field) {
        return canWin(field,opponentMoveIsOorX(field));
    }
    private boolean canWin(Field field, String side){
        String[][] cells = new String[3][3];
        cells = field.getCells();
        //Horizontal check
        for(int i = 0;i < 3;i++) {
            if(cells[i][0].equals(" ") && cells[i][1].equals(side) && cells[i][2].equals(side)){
                WinX = 0 + 1;
                WinY = 3 - i;
                return true;
            }
            if(cells[i][0].equals(side) && cells[i][1].equals(" ") && cells[i][2].equals(side)){
                WinX = 1 + 1;
                WinY = 3 - i;
                return true;
            }
            if(cells[i][0].equals(side) && cells[i][1].equals(side) && cells[i][2].equals(" ")){
                WinX = 2 + 1;
                WinY = 3 - i;
                return true;
            }
        }
        //Vertical check
        for(int j = 0;j < 3;j++) {
            if(cells[0][j].equals(" ") && cells[1][j].equals(side) && cells[2][j].equals(side)){
                WinX = j + 1;
                WinY = 3 - 0;
                return true;
            }
            if(cells[0][j].equals(side) && cells[1][j].equals(" ") && cells[2][j].equals(side)){
                WinX = j + 1;
                WinY = 3 - 1;
                return true;
            }
            if(cells[0][j].equals(side) && cells[1][j].equals(side) && cells[2][j].equals(" ")){
                WinX = j + 1;
                WinY = 3 - 2;
                return true;
            }
        }
        //diag check
        if(cells[2][0].equals(" ") && cells[1][1].equals(side) && cells[0][2].equals(side)){
            WinX = 1;
            WinY = 1;
            return true;
        }
        if(cells[2][0].equals(side) && cells[1][1].equals(" ") && cells[0][2].equals(side)){
            WinX = 2;
            WinY = 2;
            return true;
        }
        if(cells[2][0].equals(side) && cells[1][1].equals(side) && cells[0][2].equals(" ")){
            WinX = 3;
            WinY = 3;
            return true;
        }

        if(cells[0][0].equals(" ") && cells[1][1].equals(side) && cells[2][2].equals(side)){
            WinX = 1;
            WinY = 3;
            return true;
        }
        if(cells[0][0].equals(side) && cells[1][1].equals(" ") && cells[2][2].equals(side)){
            WinX = 2;
            WinY = 2;
            return true;
        }
        if(cells[0][0].equals(side) && cells[1][1].equals(side) && cells[2][2].equals(" ")){
            WinX = 3;
            WinY = 1;
            return true;
        }
    return  false;
    }
}
