package game;

import game.exceptions.InvalidWeaponException;
import game.gameWeapons.GameWeapon;
import player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  @author escopelliti
 *
 */
public class ConsoleBasedGameUIManager implements GameUIManager {


    public ConsoleBasedGameUIManager() {

        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public GameWeapon acquirePlayerWeapon() {

        String weaponName;
        GameWeapon weapon = null;
        try {
            validateWeapon((weaponName = br.readLine()));
            weapon = GameWeapon.createWeapon(weaponName);
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(InvalidWeaponException ex) {
            System.out.println("Not Allowed!!!");
            System.out.println("You can use: ");
            print_ACCEPTED_WEAPONS();
            System.out.println("Play:");
            weapon = acquirePlayerWeapon();
        }
        return weapon;
    }

    public String acquirePlayerName() {

        try {
            System.out.println("Welcome to RockPaperScissors game");
            System.out.println("Your player Name:");
            String playerName = br.readLine();
            System.out.println("Play:");
            return playerName;
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void getWinner(Player winner) {

        try {
            System.out.println("Player '" + winner.getPlayerName() + "' wins!!");
        } catch(NullPointerException ex) {
            System.out.println("Tie!!!");
        }
    }

    private void validateWeapon(String weaponName) throws InvalidWeaponException {

        int count;
        String tmp;

        count = 0;
        while(count < ACCEPTED_WEAPONS.size()) {

            tmp = ACCEPTED_WEAPONS.get(count);
            if(tmp.equals(weaponName)) {
                return;
            }
            count++;
        }
        throw new InvalidWeaponException();
    }

    private void print_ACCEPTED_WEAPONS() {

        System.out.println(ACCEPTED_WEAPONS.get(0));
        System.out.println(ACCEPTED_WEAPONS.get(1));
        System.out.println(ACCEPTED_WEAPONS.get(2));
    }

    public void printSomething(Object object) {

        System.out.println(object);
    }

    private final static List<String> ACCEPTED_WEAPONS = new ArrayList<String>() {{

        add("rock");
        add("scissors");
        add("paper");
    }};
    private BufferedReader br;
}
