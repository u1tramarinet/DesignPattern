package adapter.banner.delegate;

import adapter.banner.inheritance.Print;
import adapter.banner.inheritance.PrintBanner;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();
    }
}
