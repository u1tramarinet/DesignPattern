package strategy.janken;

public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
