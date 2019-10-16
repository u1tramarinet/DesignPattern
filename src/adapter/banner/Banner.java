package adapter.banner;

public class Banner {
    private String content;

    public Banner(String content) {
        this.content = content;
    }

    public void showWithParen() {
        println("(" + content + ")");
    }

    public void showWithAster() {
        println("*" + content + "*");
    }

    private void println(String text) {
        System.out.println(text);
    }
}
