package game;

import game.gameEngine.DefaultGameEngine;
import game.gameEngine.GameEngine;
import game.gameRule.IGameRule;
import game.gameWeapons.GameWeapon;
import player.Player;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author escopelliti
 *
 */
public class Game {

    public Game(String gameName, GameUIManager gameUIManager,ArrayList<IGameRule> IGameRules, List<GameWeapon> gameWeapons){

        this.gameUIManager = gameUIManager;
        this.gameName = gameName;
        this.IGameRules = IGameRules;
        this.gameWeapons = gameWeapons;
        this.gameEngine = new DefaultGameEngine(this.IGameRules);
    }

    public GameRound createNewGameRound() {

        Player player = createNewPlayer();
        GameWeapon playedWeapon = gameUIManager.acquirePlayerWeapon();
        GameRound gameRound = new GameRound(player, playedWeapon);
        return gameRound;
    }

    private Player createNewPlayer() {
        Player player = new Player();
        String playerName = gameUIManager.acquirePlayerName();
        player.setPlayerName(playerName);
        return player;
    }

    public void getWinner(GameRound playerRound1, GameRound playerRound2) {

        Player winner = gameEngine.getWinner(playerRound1, playerRound2);
        this.gameUIManager.getWinner(winner);
    }

    private final GameUIManager gameUIManager;
    private final List<GameWeapon> gameWeapons;
    private GameEngine gameEngine;
    private String gameName;
    private ArrayList<IGameRule> IGameRules;
}