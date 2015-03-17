import game.Game;
import game.GameRound;
import game.RockPaperScissorsFactory;

/**
 *
 * @author escopelliti
 *
 */
public class Starter {

    public static void main(String[] args) {


        Game RockPaperScissors;

        RockPaperScissors = RockPaperScissorsFactory.createGame();
        GameRound firstPlayerRound = RockPaperScissors.createNewGameRound();
        GameRound secondPlayerRound = RockPaperScissors.createNewGameRound();
        RockPaperScissors.getWinner(firstPlayerRound, secondPlayerRound);
        System.exit(0);
    }
}