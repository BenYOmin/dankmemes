package benjaminshawki.papasspel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Shawki
 * @version --
 */
public class Player {

    private String name;
    private List<Card> hand;
    private Card playerGroundCard;
    private int points = 0;
    private int gamesWon = 0;
    private boolean wonTurn = false;
    private boolean containsSuit = false;

    public Player(String name){
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public Card getPlayerGroundCard() {
        return playerGroundCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHand(Card card) {
        hand.add(card);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void setPlayerGroundCard(Card playerGroundCard) {
        this.playerGroundCard = playerGroundCard;
    }

    public boolean isWonTurn() {
        return wonTurn;
    }

    public void setWonTurn(boolean wonTurn) {
        this.wonTurn = wonTurn;
    }

    public boolean isContainsSuit() {
        return containsSuit;
    }

    public void displayHand() {

        for (Card card : hand) {
            System.out.println(card.getSuit().toString() + " " + card.getRank().toString());
        }
    }
}
