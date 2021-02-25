package hiperskill.projects.tictactoe;

abstract class Player {
    Field fieldTemp;

    void move(Field field) throws CloneNotSupportedException {

    }
    static String myMoveIsOorX(Field field) {
        // O or X
        if(field.getCounterX() == field.getCounterO() + 1) return "O";
        else return "X";
    }
    static String opponentMoveIsOorX(Field field) {
        // O or X
        if(field.getCounterX() == field.getCounterO() + 1) return "X";
        else return "O";
    }

//    public void cloneField() {
//        fieldTemp = Main.Field.getField();
//        System.out.println(fieldTemp);
//    };
}
