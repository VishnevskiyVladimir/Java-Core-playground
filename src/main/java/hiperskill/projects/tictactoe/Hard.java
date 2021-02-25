package hiperskill.projects.tictactoe;

public class Hard extends Player {
    private Field myField = null;
    String myMoveSign;
    String opponentSign;
    @Override
    void move(Field field) throws CloneNotSupportedException {
        myField = field.clone();
        myMoveSign = myMoveIsOorX(field);
        opponentSign = opponentMoveIsOorX(field);
        int xBest = 1;
        int yBest = 1;
        System.out.println("Making move level \"hard\"" + "my move is " + myMoveIsOorX(field));


        int best_score = Integer.MIN_VALUE;
        int score_ = Integer.MIN_VALUE;
        for(int x = 1; x<4;x++){
            for(int y = 1; y<4;y++){
                if(!myField.isOccupied(x,y)) {
                    if (myMoveSign.equals("X")) myField.setCell_X(x, y);
                    else myField.setCell_O(x, y);
                    score_ = minimax(myField, 0, false);
                    myField.clearCell(x, y);
                    if (score_ > best_score) {
                        best_score = score_;
                        xBest = x;
                        yBest = y;
                    }
                }
            }
        }
        if (myMoveIsOorX(field).equals("X")) field.setCell_X(xBest, yBest);
        else field.setCell_O(xBest, yBest);
        return;
    }
    int minimax (Field minimax_field, int depth, boolean is_maximizing){

        int bestscore = 0;
        int score = 0;
        int checkEnd = minimax_field.gameEndCheckForMinimax(myMoveSign);
        if(checkEnd == 2){
            return 10;
        } else if (checkEnd == 3){
            return -10;
        } else if (checkEnd == 1){
            return 0;
        }
        if(is_maximizing){
            //выбираем ход который нам выгодней
            bestscore = Integer.MIN_VALUE;
            for(int x = 1; x<4;x++){
                for(int y =1; y<4;y++){
                    if(!minimax_field.isOccupied(x,y)) {
                        if (myMoveSign.equals("X")) minimax_field.setCell_X(x, y);
                        else minimax_field.setCell_O(x, y);
                        score = minimax(minimax_field, depth + 1, false);
                        minimax_field.clearCell(x,y);
                        bestscore = Math.max(bestscore, score);
//                        System.out.println("клон глубина " + depth);
//                        System.out.println(minimax_field);
                    }
                }
            }
        } else {
            //противник выбирает самый невыгодный для нас ход
            bestscore = Integer.MAX_VALUE;
            for(int x = 1; x<4;x++){
                for(int y =1; y<4;y++){
                    if(!minimax_field.isOccupied(x,y)) {
                        if (opponentSign.equals("X")) minimax_field.setCell_X(x, y);
                        else minimax_field.setCell_O(x, y);
                        score = minimax(minimax_field, depth + 1, true);
                        minimax_field.clearCell(x,y);
                        bestscore = Math.min(bestscore, score);
//                        System.out.println("клон глубина " + depth);
//                        System.out.println(minimax_field);
                    }
                }
            }
        }


        return bestscore;
    }
}
