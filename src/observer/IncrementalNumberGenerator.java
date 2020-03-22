package observer;

public class IncrementalNumberGenerator extends NumberGenerator {

    private int start;
    private int end;
    private int incremental;
    private int number;

    public IncrementalNumberGenerator(int start, int end, int incremental) {
        this.start = start;
        this.end = end;
        this.incremental = incremental;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = start; i < end; i += incremental) {
            number = i;
            notifyObservers();
        }
    }
}
