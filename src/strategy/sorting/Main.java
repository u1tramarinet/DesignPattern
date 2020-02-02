package strategy.sorting;

public class Main {
    public static void main(String[] args) {
        String[] data = {
                "Dumpty", "Bowman", "Carroll", "Elfland", "Alice"
        };

        SortAndPrint sortAndPrint = new SortAndPrint(data, new SelectionSorter());
        sortAndPrint.execute();
    }
}
