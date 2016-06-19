package benjaminshawki.papasspel;

import benjaminshawki.papasspel.enums.Rank;
import benjaminshawki.papasspel.enums.Suit;

import java.lang.reflect.Array;

/**
 * @author Benjamin Shawki
 * @version --
 */
public class Card {

    private Suit suit;
    private Rank rank;
    private String stringSuit;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }


}
