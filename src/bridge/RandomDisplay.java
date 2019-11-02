package bridge;

public class RandomDisplay extends Display {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        open();
        times = (int)(Math.random() * times);
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
