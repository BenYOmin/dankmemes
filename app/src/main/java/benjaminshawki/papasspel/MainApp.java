package benjaminshawki.papasspel;

/**
 * @author Benjamin Shawki
 * @version 0.1 17-6-16
 */
public class MainApp {

    private static MainApp mainApp;
    private PappasSpel pappasSpel;
    private Player player;

    public MainApp() {
        mainApp = this;
        this.pappasSpel = new PappasSpel();
    }

    public static void main(String[] args) {
        new MainApp();
    }

    public static MainApp getInstance() {
        return mainApp;
    }

    public PappasSpel getPappasSpel() {
        return pappasSpel;
    }

    public void setPappasSpel(PappasSpel pappasSpel) {
        this.pappasSpel = pappasSpel;
    }
}
