package builder;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }

        if (args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.constract();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.constract();
            String filename = htmlBuilder.getFilename();
            System.out.println(filename + "が作成されました。");
        } else {
            usage();
            System.exit(0);
        }

    }

    private static void usage() {
        System.out.println("Usage: java Main plain      プレーンテキストで文書作成");
        System.out.println("Usage: java Main html       HTMLファイルで文書作成");
    }
}
