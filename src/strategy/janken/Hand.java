package strategy.janken;

public class Hand {
    public static final Hand[] hands = {
            new Hand(0, "グー"),
            new Hand(1, "チョキ"),
            new Hand(2, "パー")
    };

    private int handValue;
    private String handName;

    private Hand(int handValue, String handName) {
        this.handValue = handValue;
        this.handName = handName;
    }

    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    public boolean isStrongerThan(Hand hand) {
        return (fight(hand) == 1);
    }

    public boolean isWeakerThan(Hand hand) {
        return (fight(hand) == -1);
    }

    private int fight(Hand hand) {
        if (this == hand) {
            return 0;
        } else if (((this.handValue + 1) % 3 == hand.handValue)) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return handName;
    }
}
