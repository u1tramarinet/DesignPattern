package adapter.delegate;

import adapter.Banner;

public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(String content) {
        this.banner = new Banner(content);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
