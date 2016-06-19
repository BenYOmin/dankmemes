package benjaminshawki.papasspel.enums;

/**
 * @author Benjamin Shawki
 * @version --
 */
public enum Rank {
    TWO("Two"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace");

    private String name;

    Rank(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
