package database;

import com.mongodb.*;

import static game.GameTestingUtils.*;

import game.GameRound;
import junit.framework.Assert;
import org.junit.Test;
import player.Player;

import static org.easymock.EasyMock.*;

/**
 *
 * @author escopelliti
 *
 */

public class MongoDBManagerTest {

    private MongoDBManager mongoDBManager = new MongoDBManager();

    @Test
    public void testConnectToDB_DBIsNotNull(){

        DB db = mongoDBManager.connectToDB();
        Assert.assertNotNull(db);
        Assert.assertSame(db.getName(), "GameRoundCollection");
    }

    @Test
    public void testStoreGameRound_ValuesInsertedCorrectly() {

        GameRound gameRound1, gameRound2;
        gameRound1 = createMock("gameRound1", GameRound.class);
        Player player1 = createMock(Player.class);
        expect(player1.getPlayerName()).andReturn("Paul");
        expect(gameRound1.getRoundPlayer()).andReturn(player1);
        expect(gameRound1.getPlayedWeapon()).andReturn(WEAPON_3);
        Player player2 = createMock(Player.class);
        expect(player2.getPlayerName()).andReturn("Alice");
        gameRound2 = createMock("gameRound2", GameRound.class);
        expect(gameRound2.getRoundPlayer()).andReturn(player2);
        expect(gameRound2.getPlayedWeapon()).andReturn(WEAPON_1);
        DB db = createMock(DB.class);
        DBCollection dbCollection = createMock(DBCollection.class);
        expect(db.getCollection("GameRound")).andReturn(dbCollection);
        BasicDBObject document = createMock(BasicDBObject.class);
        expect(document.put("name", "Paul")).andReturn(new Object());
        expect(document.put("played weapon", WEAPON_3)).andReturn(new Object());
        expect(document.put("name", "Alice")).andReturn(new Object());
        expect(document.put("played weapon", WEAPON_1)).andReturn(new Object());
        expect(dbCollection.insert(document)).andReturn(createNiceMock(WriteResult.class));

        replay(gameRound1, gameRound2, player1, player2, db, document, dbCollection);
        mongoDBManager.storeGameRound(gameRound1, gameRound2);
        mongoDBManager.readGameRound();
        verify(gameRound1, gameRound2, player1, player2, db, document, dbCollection);
    }


}
