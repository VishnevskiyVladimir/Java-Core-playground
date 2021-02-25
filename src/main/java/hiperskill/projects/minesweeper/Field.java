package hiperskill.projects.minesweeper;
import java.util.*;


public class Field {
    private final Scanner scanner = new Scanner(System.in);
    private int amountOfMines;
    private final int fieldSize = 9;
    private int markedMinesCounter = 0;
    private int wrongMarksCounter = 0;
    private int gameStatus = 0; // 0 - in progress, 1 - loss, 2 - victory

    /* ================================================================
        в cells хранятся значения для отображения пользователю:
        "/" - пустая
        "\\n" - ячейка граничащая с миной
        "*" - mine mark
     ------------------------------------------------------------------
        в mask хранятся флаги видимости:
        true - ячейка видима
        false - ячейка скрыта
     ===================================================================*/
    private String[][] cells = new String[fieldSize][fieldSize];
    private boolean[][] mask = new boolean[fieldSize][fieldSize];
    private char[][] marks = new char[fieldSize][fieldSize];
    private Mine[] mines;


    Field(int amountOfMines) {
        this.amountOfMines = amountOfMines;
    }
    public int getGameStatus() {
        return gameStatus;
    }

    void generateCells(int amountOfMines,int firstX, int firstY) {
        for (int i = 0; i < fieldSize; i++) {
            Arrays.fill(cells[i], "/");
            Arrays.fill(marks[i], ' ');
        }

        generateMines(amountOfMines, firstX, firstY);
        generateNumbers();
        reveal(firstX,firstY);
        printMines();
    }

    private void generateMines(int amountOfMines, int firstX, int firstY) {
        this.amountOfMines = amountOfMines;
        mines = new Mine[amountOfMines];

        long time = System.currentTimeMillis() / 1000L;

        Random rand1 = new Random(time/3);
        Random rand2 = new Random(time/2);
        int count = 0, x = 0, y = 0;

        // удали
        //cells[firstX][firstY] = "F";
        //mask[firstX][firstY] = true;


        while (count < amountOfMines) {
            x = rand1.nextInt(9);
            y = rand2.nextInt(9);

            //======== блок 3х3 с центром в ячейке первого хода оставляю свободными=======
            if ((x == firstX - 1 || x == firstX || x == firstX + 1) &&
                (y == firstY - 1 || y == firstY || y == firstY + 1)) {
                //cells[x][y] = "E";
                //mask[x][y]= true;
                continue;
            }
            if (!hereIsMine(x, y)) {
                mines[count] = new Mine(x,y);
                count++;
                // удали
                cells[x][y] = "M";
                //mask[x][y]= true;
            }
        }

    }

    private void generateNumbers() {
        int x = 0, y = 0, aux = 0;
        for (Mine mine : mines) {
            x = mine.getX();
            y = mine.getY();
            for (int j = x - 1; j < x +2; j++) {
                if (j < 0 || j >= fieldSize) {
                    continue;
                }
                for(int k = y - 1; k < y + 2; k++) {
                    if (k < 0 || k >= fieldSize) {
                        continue;
                    }
                    if (cells[j][k] == "/") {
                        cells[j][k] = "1";
                        mask[j][k] = true;
                    } else if (cells[j][k].matches("\\d")) {
                        aux = Integer.parseInt(cells[j][k]) + 1;
                        cells[j][k] = String.valueOf(aux);
                    }
                }
            }
        }
    }


    private boolean hereIsMine(int x, int y) {
        for (Mine m :
                mines) {
            if(m != null && x == m.getX() && y == m.getY()) {
                return true;
            }
        }
        return false;
    }







    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" │123456789│\n");
        sb.append("—│—————————│\n");
        for (int k = 0; k < 9; k++) {
            sb.append(k+1 + "|");
            for (int i = 0; i < 9; i++) {
                if(!mask[i][k]) {
                    sb.append(".");
                } else if(mask[i][k] && (marks[i][k] == '+'||marks[i][k] == '-')) {
                    sb.append("*");
                }else {
                    sb.append(cells[i][k]);
                }
            }
            sb.append("|\n");
        }
        sb.append("—│—————————│\n");
        return new String(sb);
    }
    private void setMark(int x, int y) {
        if(hereIsMine(x,y)) {
            if (marks[x][y] == ' ') {
                marks[x][y] = '+';
                mask[x][y] = true;
                markedMinesCounter++;
                for (Mine m :
                        mines) {
                    if (x == m.getX() && y == m.getY()) {
                        m.setMarked(true);
                    }
                }
            } else if (marks[x][y] == '+') {
                marks[x][y] = ' ';
                mask[x][y] = false;
                markedMinesCounter--;
                for (Mine m :
                        mines) {
                    if (x == m.getX() && y == m.getY()) {
                        m.setMarked(false);
                    }
                }
            }
        } else {
            if (marks[x][y] == ' ') {
                marks[x][y] = '-';
                mask[x][y] = true;
                wrongMarksCounter++;
            } else if (marks[x][y] == '-') {
                marks[x][y] = ' ';
                mask[x][y] = false;
                wrongMarksCounter--;
            }
        }
        printMines();
    }

    public void userMove() {
       //while (true) {
            System.out.print("Set/unset mines marks or claim a cell as free: ");
            String inLine = scanner.nextLine();
            String[] inArr = inLine.split("\\s");
            int x = Integer.parseInt(inArr[0]) - 1;
            int y = Integer.parseInt(inArr[1]) - 1;
            String command = inArr[2];

            if(command.equals("mine")) {
                setMark(x,y);
            } else if (command.equals("free")) {
                if(!hereIsMine(x,y)) reveal(x, y);
                else blow();
            }
            if (markedMinesCounter == amountOfMines &&
                wrongMarksCounter == 0) {
                gameStatus = 2;
            }
    }

    private void blow() {
        for (Mine m :
                mines) {
            cells[m.getX()][m.getY()] = "X";
            mask[m.getX()][m.getY()] = true;
        }
        gameStatus = 1;

    }

    private boolean isOutBounds(int x, int y) {
        return x < 0  || y < 0 || x >= fieldSize || y >= fieldSize;
    }
    private void reveal(int x, int y) {
        if (isOutBounds(x,y)) return;
        if (isRevealed(x,y) && marks[x][y] == ' ') return;
        if(marks[x][y] == '-') {
            marks[x][y] = ' ';
            wrongMarksCounter--;
        }
        mask[x][y] = true;

        if (cells[x][y].matches("\\d")) return;
        reveal(x - 1, y - 1);
        reveal(x - 1, y + 1);
        reveal(x + 1, y - 1);
        reveal(x + 1, y + 1);
        reveal(x - 1, y);
        reveal(x + 1, y);
        reveal(x, y - 1);
        reveal(x, y + 1);
    }

    private boolean isRevealed(int x, int y) {
        return mask[x][y] == true;
    }


    class Cell {
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        protected int x;
        protected int y;

        public void setX(int x) {
            this.x = x;
        }

        void setY(int y) {
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "[x = " + (x + 1) + ", y = " + (y + 1) +"]";
        }
    }
    final private class Mine extends Cell {
        private boolean isMarked = false;


        public Mine(int x, int y) {
            super(x,y);
        }



        public boolean isMarked() {
            return isMarked;
        }

        public void setMarked(boolean marked) {
            isMarked = marked;
        }
        @Override
        public String toString() {
            return "[x = " + (x + 1) + ", y = " + (y + 1) + ", is marked = " + isMarked + "]";
        }

    }

    public void printMines() {
        System.out.println(Arrays.toString(mines));
    }

    final private class Mark extends Cell {
        private String actualVal;

        public void setActualVal(String actualVal) {
            this.actualVal = actualVal;
        }

        public String getActualVal() {
            return actualVal;
        }

        public Mark(int x, int y, String actualVal) {
            super(x, y);
            this.actualVal = actualVal;
        }
    }

}





