package benjaminshawki.papasspel;

import benjaminshawki.papasspel.enums.Rank;
import benjaminshawki.papasspel.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Benjamin Shawki
 * @version --
 */
public class PappasSpel {

    private MainApp mainApp;
    private Player player;
    private Player firstPlayer;
    private List<Card> cards;
    private List<Card> ground;
    private List<Player> alPlayers;
    private int turn = 0;
    private int round = 0;
    private int playersPlayed = 0;

    public PappasSpel(){
        mainApp = MainApp.getInstance();

        alPlayers = new ArrayList<>();
        cards = new ArrayList<>();
        ground = new ArrayList<>();
        createCards();

        createPlayer("Henk");
        createPlayer("Pietersen");
        createPlayer("Andre");
        dealCards();
        displayHand();

    }

    public int getTurn() {
        return turn;
    }

    public int getRound() {
        return round;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }


    public void setTurn(int turn) {
        if (turn == alPlayers.size()){
            turn = 0;
        }
        if(getPlayersPlayed() == alPlayers.size()) {
            setRound(getRound() + 1);
        }
        this.turn = turn;
    }

    public int getPlayersPlayed() {
        return playersPlayed;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Player getCurrentPlayer() {
        return alPlayers.get(getTurn());
    }

    public void setPlayersPlayed(int playersPlayed) {
        if(playersPlayed == alPlayers.size()) {
            playersPlayed = 0;
        }
        this.playersPlayed = playersPlayed;
    }


    public void setFirstPlayer(Player firstPlayer) {
        setTurn(alPlayers.indexOf(firstPlayer));
        this.firstPlayer = firstPlayer;
    }


    public void createCards() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public Player createPlayer(String name) {
        player = new Player(name);
        alPlayers.add(player);
        return player;
    }


    public void dealCards() {
        Collections.shuffle(cards);
        for (Card card : cards) {
            System.out.println(card.getSuit().toString() + " " + card.getRank().toString());
        }

        int handSize = cards.size() / alPlayers.size();
        for(int i = 0; i < alPlayers.size(); i++) {
            for (int j = i * handSize; j < (i * handSize + handSize); j++) {
                alPlayers.get(i).setHand(cards.get(j));
            }

        }
    }

    public void displayHand() {
        for (Player player : alPlayers) {
            System.out.println();
            player.displayHand();
        }
    }


    public void playSecondaryTurn(Card card) {
        boolean containsSuit = false;
        for (Card hand : getCurrentPlayer().getHand()){
            if(firstPlayer.getPlayerGroundCard().getSuit() == hand.getSuit()){
                containsSuit = true;
            }
        }
        if((containsSuit && card.getSuit() == firstPlayer.getPlayerGroundCard().getSuit())
            || containsSuit == false && card.getSuit() != firstPlayer.getPlayerGroundCard().getSuit()) {
            playCard(card);
        }
    }


    public void playFirstTurn(Card  card) {
        playCard(card);
    }

    public void playTurn(Card card) {
        if(getRound() == 0 || getCurrentPlayer().isWonTurn()) {
            playFirstTurn(card);
        }
        else {
            playSecondaryTurn(card);
        }
    }

    public Player highestCard() {
        Player highest = getFirstPlayer();
        int index = alPlayers.indexOf(getFirstPlayer());
        for (Card card : ground) {
            if(highest.getPlayerGroundCard().getSuit() == card.getSuit()
                && card.getRank().ordinal() > highest.getPlayerGroundCard().getRank().ordinal()) {
                highest = alPlayers.get(index);
            }
            index++;
            if(index == alPlayers.size()) {
                index = 0;
            }
        }
        return highest;
    }

    public void round() {

    }

    public void playCard(Card card) {
        ground.add(card);
        getCurrentPlayer().setPlayerGroundCard(card);
        getCurrentPlayer().getHand().remove(card);
        setTurn(getTurn() + 1);
        setPlayersPlayed(getPlayersPlayed() + 1);
    }
}
