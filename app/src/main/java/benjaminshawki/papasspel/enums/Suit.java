package benjaminshawki.papasspel.enums;

/**
 * @author Benjamin Shawki
 * @version --
 */
public enum Suit {
    SPADES("Spades"),
    HEARTHS("Hearths"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds");

    private String name;

    Suit(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
