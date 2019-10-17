package templateMethod;

public class StringDisplay extends AbstractDisplay {

    private String str;
    private int strWidth = 0;

    public StringDisplay(String str) {
        this.str = str;
        if (str != null) {
            strWidth = str.getBytes().length;
        }
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.print("|");
        System.out.print(str);
        System.out.println("|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < strWidth; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
