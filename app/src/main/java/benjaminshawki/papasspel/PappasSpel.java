package benjaminshawki.papasspel;

import benjaminshawki.papasspel.enums.Rank;
import benjaminshawki.papasspel.enums.Suit;

import java.lang.reflect.Array;

/**
 * @author Benjamin Shawki
 * @version --
 */
public class PappasSpel {

    private MainApp mainApp;
    private Card[] cards;

    public PappasSpel(){
        mainApp = MainApp.getInstance();

        cards = new Card[52];
        createCards();

    }

    public void createCards() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[suit.ordinal() * rank.ordinal()] = new Card(suit, rank);
            }
        }
    }
}
