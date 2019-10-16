package adapter.delegate;

import adapter.inheritance.Print;
import adapter.inheritance.PrintBanner;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();
    }
}
