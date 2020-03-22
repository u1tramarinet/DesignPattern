package observer;

public class Main {

    public static void main(String[] args) {
        observe(new RandomNumberGenerator());
        observe(new IncrementalNumberGenerator(10, 50, 5));
    }

    private static void observe(NumberGenerator generator) {
        System.out.println("**************** " + generator.getClass().getSimpleName() + " ****************");
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }

}
