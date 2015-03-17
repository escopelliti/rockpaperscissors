package database;

import com.mongodb.DB;
import game.GameRound;

import java.net.UnknownHostException;

/**
 *
 * @author escopelliti
 *
 */
public interface DBManager {

    public void storeGameRound(GameRound gameRound1, GameRound gameRound2);
    public DB connectToDB();
    public void closeConnectionToDB();
    public void readGameRound();
}
