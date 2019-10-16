package adapter.inheritance;

import adapter.Banner;

public class PrintBanner extends Banner implements Print {

    public PrintBanner(String content) {
        super(content);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
