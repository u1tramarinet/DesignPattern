package strategy.janken;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;

    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue = 0;
        int threshold = 0;

        for (int i = 0; i < history[currentHandValue].length; i++) {
            threshold += history[currentHandValue][i];
            if (bet < threshold) {
                handValue = i;
                break;
            }
        }

        prevHandValue = currentHandValue;
        currentHandValue = handValue;
        return Hand.getHand(handValue);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            recordHistory(currentHandValue);
        } else {
            recordHistory(((currentHandValue + 1) % 3));
            recordHistory(((currentHandValue + 2) % 3));
        }
    }

    private int getSum(int handValue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handValue][i];
        }
        return sum;
    }

    private void recordHistory(int handValue) {
        history[prevHandValue][handValue]++;
    }
}
