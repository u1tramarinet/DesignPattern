package observer;

public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver: ");
        int number = generator.getNumber();
        for (int i = 1; i <= number; i++) {
            System.out.print(getPoint(i));
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getPoint(int position) {
        if (isMultipleOf(10, position, true)) {
            return "|";
        } else if (isMultipleOf(5, position, true)) {
            return "*";
        }
        return "-";
    }

    @SuppressWarnings("SameParameterValue")
    private boolean isMultipleOf(int multiple, int number, boolean exceptZero) {
        if (exceptZero && (number == 0)) {
            return false;
        }
        return (number % multiple == 0);
    }
}
