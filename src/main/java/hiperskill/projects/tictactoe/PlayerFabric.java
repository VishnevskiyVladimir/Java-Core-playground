package hiperskill.projects.tictactoe;

public class PlayerFabric {

    private Player newPlayer = null;

    public Player getNewPlayer(String condition) {
        if(condition.equals("easy")) {
            newPlayer = new Easy();
        } else if (condition.equals("medium")){
            newPlayer = new Medium();
        } else if (condition.equals("hard")){
            newPlayer = new Hard();
        } else if (condition.equals("user")){
            newPlayer = new User();
        }
        return newPlayer;
    }
}
