package hiperskill.projects.tictactoe;



public class Field implements Cloneable {
    String[][] cells = new String[3][3];
    private int counterX;
    private int counterO;
    int gameStatus;
    int whoIsWinner;


    public Field clone() throws CloneNotSupportedException {
        Field clone=(Field)super.clone();
        clone.cells = new String[3][3];
        for(int i=0;i<3;i++) clone.cells[i]=this.cells[i].clone();
        return clone;
    }


    public Field(String fieldInitial) {
        fieldInitial = fieldInitial.replace('_', ' ');
        this.cellsFill(fieldInitial);
        counterO = 0;
        counterX = 0;
        gameStatus = 0;
    }
    public Field() {
        this.cellsFill("         ");
        counterO = 0;
        counterX = 0;
        gameStatus = 0;
    }
    public String[][] getCells() {
        return cells.clone();
    }
    public int getCounterX() {
        return counterX;
    }
    public int getCounterO() {
        return counterO;
    }

    private void cellsFill(String in) {
        for (int i = 0;i < 3;i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    cells[i][j] = String.valueOf(in.charAt(j));
                } else if (i == 1) {
                    cells[i][j] = String.valueOf(in.charAt(j + 3));
                } else if (i == 2) {
                    cells[i][j] = String.valueOf(in.charAt(j + 6));
                }
                if (cells[i][j].equals("X")) {
                    counterX++;
                } else if (cells[i][j].equals("O")) {
                    counterO++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("---------").append("\n");
        for (String[] cell : cells) {
            builder.append("|");
            builder.append(" ").append(cell[0]);
            builder.append(" ").append(cell[1]);
            builder.append(" ").append(cell[2]);
            builder.append(" |").append("\n");
        }
        builder.append("---------");

        return builder.toString();
    }

    public  boolean isOccupied(int x, int y) {
        String c = getCell(x, y);
        return c.equals("X") || c.equals("O");
    }

    public String getCell(int x, int y) {
        return cells[3 - y][x - 1];
    }


    public void setCell_X(int x, int y) {
        cells[3 - y][x - 1] = "X";
        counterX++;
    }
    public void setCell_O(int x, int y) {
        cells[3 - y][x - 1] = "O";
        counterO++;
    }
    public void clearCell(int x, int y) {
        cells[3 - y][x - 1] = "";
        counterO++;
    }


    public  void checkGameStatus() {
        //horiz check
        for (int i = 0; i < cells.length;i++) {
            if (cells[i][0].equals(cells[i][1])  &&
                    cells[i][0].equals(cells[i][2]) &&
                    cells[i][0].equals("X")) {
                gameStatus = 2;
                break;
            } else if(cells[i][0].equals(cells[i][1])  &&
                    cells[i][0].equals(cells[i][2]) &&
                    cells[i][0].equals("O")) {
                gameStatus = 3;
                break;
            }
        }

        //vert check
        for (int i = 0; i < cells.length;i++) {
            if (cells[0][i].equals(cells[1][i])  &&
                    cells[0][i].equals(cells[2][i]) &&
                    cells[0][i].equals("X")) {
                gameStatus = 2;
                break;
            } else if(cells[0][i].equals(cells[1][i])  &&
                    cells[0][i].equals(cells[2][i]) &&
                    cells[0][i].equals("O")) {
                gameStatus = 3;
                break;
            }
        }

        //diag check
        if (cells[0][0].equals(cells[1][1]) &&
                cells[0][0].equals(cells[2][2]) &&
                cells[0][0].equals("X")) {
            gameStatus = 2;
        } else if (cells[0][2].equals(cells[1][1]) &&
                cells[0][2].equals(cells[2][0]) &&
                cells[0][2].equals("X")) {
            gameStatus = 2;
        } else {
            if ((cells[0][0].equals(cells[1][1]) &&
                    cells[0][0].equals(cells[2][2]) &&
                    cells[0][0].equals("O"))
                    ||
                    (cells[0][2].equals(cells[1][1]) &&
                            cells[0][2].equals(cells[2][0]) &&
                            cells[0][2].equals("O"))) {
                gameStatus = 3;
            }
        }

        if((counterX + counterO) == 9 && gameStatus == 0) {
            gameStatus = 1;
        }

        if (gameStatus == 0) {
            System.out.println("Game not finished");
        } else if (gameStatus == 1) {
            System.out.println("Draw");
            Main.gameIsStarted = false;
        } else if (gameStatus == 2) {
            System.out.println("X wins");
            Main.gameIsStarted = false;
        } else if (gameStatus == 3) {
            System.out.println("O wins");
            Main.gameIsStarted = false;
        } else {
            System.out.println("Error in gameStatusCheck()");
        }
    }
    public  int gameEndCheckForMinimax(String myLetter) {
        int status = 0;

        //horiz check
        for (int i = 0; i < cells.length;i++) {
            if (cells[i][0].equals(cells[i][1])  &&
                    cells[i][0].equals(cells[i][2]) &&
                    cells[i][0].equals("X")) {
                status = 2;
                break;
            } else if(cells[i][0].equals(cells[i][1])  &&
                    cells[i][0].equals(cells[i][2]) &&
                    cells[i][0].equals("O")) {
                status = 3;
                break;
            }
        }

        //vert check
        for (int i = 0; i < cells.length;i++) {
            if (cells[0][i].equals(cells[1][i])  &&
                    cells[0][i].equals(cells[2][i]) &&
                    cells[0][i].equals("X")) {
                status = 2;
                break;
            } else if(cells[0][i].equals(cells[1][i])  &&
                    cells[0][i].equals(cells[2][i]) &&
                    cells[0][i].equals("O")) {
                status = 3;
                break;
            }
        }

        //diag check
        if (cells[0][0].equals(cells[1][1]) &&
                cells[0][0].equals(cells[2][2]) &&
                cells[0][0].equals("X")) {
            status = 2;
        } else if (cells[0][2].equals(cells[1][1]) &&
                cells[0][2].equals(cells[2][0]) &&
                cells[0][2].equals("X")) {
            status = 2;
        } else {
            if ((cells[0][0].equals(cells[1][1]) &&
                    cells[0][0].equals(cells[2][2]) &&
                    cells[0][0].equals("O"))
                    ||
                    (cells[0][2].equals(cells[1][1]) &&
                            cells[0][2].equals(cells[2][0]) &&
                            cells[0][2].equals("O"))) {
                status = 3;
            }
        }

        if((counterX + counterO) == 9 && status == 0) {
            status = 1;
        }

        if (status == 0) {
            //System.out.println("Game not finished");
            whoIsWinner = 0;
        } else if (status == 1) {
            //System.out.println("Draw");
            whoIsWinner = 1;

        } else if (status == 2) {
            //System.out.println("X wins");
            if(myLetter.equals("X")) whoIsWinner = 2;
            else whoIsWinner = 3;


        } else if (status == 3) {
            //System.out.println("O wins");
            if(myLetter.equals("O")) whoIsWinner = 2;
            else whoIsWinner = 3;

        } else {
            //System.out.println("Error in gameStatusCheck()");
        }
        return whoIsWinner;
    }

}