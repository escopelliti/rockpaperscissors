package database;

import com.mongodb.*;
import game.ConsoleBasedGameUIManager;
import game.GameRound;
import game.gameWeapons.GameWeapon;
import player.Player;

import java.net.UnknownHostException;

/**
 *
 * @author escopelliti
 *
 */
public class MongoDBManager implements DBManager {

    private MongoClient mongoClient;
    DB db;
    private ConsoleBasedGameUIManager gameUIManager = new ConsoleBasedGameUIManager();

    @Override
    public void storeGameRound(GameRound gameRound1, GameRound gameRound2) {

        DBCollection gameRoundCollection = getGameRoundCollection();
        BasicDBObject document = new BasicDBObject();
        Player player1 = gameRound1.getRoundPlayer();
        String playerName1 = player1.getPlayerName();
        document.put("name", playerName1);
        GameWeapon playedWeapon1 = gameRound1.getPlayedWeapon();
        document.put("played weapon", playedWeapon1.getWeaponName());
        Player player2 = gameRound1.getRoundPlayer();
        String playerName2 = player2.getPlayerName();
        document.put("name", playerName2);
        GameWeapon playedWeapon2 = gameRound2.getPlayedWeapon();
        document.put("played weapon", playedWeapon2.getWeaponName());

        gameRoundCollection.insert(document);

    }

    private String[] getCredentials() {

        //TODO Read file for configuration (decrypt)
        return null;
    }

    @Override
    public DB connectToDB() {
        try {
            this.mongoClient = new MongoClient();
            this.db = this.mongoClient.getDB("GameRoundCollection");
            //db.authenticate("username", "password".toCharArray());
        } catch(UnknownHostException ex) {
            this.gameUIManager.printSomething("Impossible to connect.");
        }
        return this.db;
    }

    private DBCollection getGameRoundCollection() {

        return this.db.getCollection("GameRound");
    }

    @Override
    public void closeConnectionToDB() {
        this.mongoClient.close();
    }

    @Override
    public void readGameRound() {

        DBCollection gameRoundCollection = getGameRoundCollection();
        for (DBObject dbObject : gameRoundCollection.find()) {
            this.gameUIManager.printSomething(dbObject);
        }
    }
}
