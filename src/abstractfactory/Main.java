package abstractfactory;

import abstractfactory.factory.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }

        Factory factory = Factory.getFactory(args[0]);

        Tray news = factory.createTray("新聞");
        news.add(factory.createLink("朝日新聞", "http://www.asahi.com/"));
        news.add(factory.createLink("読売新聞", "http://www.yomiuri.co.jp/"));

        Tray yahoo = factory.createTray("Yahoo!");
        yahoo.add(factory.createLink("Yahoo!", "http://www.yahoo.com/"));
        yahoo.add(factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/"));

        Tray search = factory.createTray("サーチエンジン");
        search.add(yahoo);
        search.add(factory.createLink("Excite", "http://www.excite.com/"));
        search.add(factory.createLink("google", "http://www.google.com/"));

        Page page = factory.createPage("LinkPage", "だれか");
        page.add(news);
        page.add(search);
        page.output();
    }

    private static void usage() {
        System.out.println("Usage: java Main class.name.of.ConcreteFactory");
        System.out.println("Example 1: java Main listfactory.ListFactory");
        System.out.println("Example 2: java Main tablefactory.TableFactory");
    }
}
