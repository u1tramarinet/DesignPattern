package visitor;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            startMain("main01");
            main01();
            startMain("main02");
            main02();
            startMain("main03");
            main03();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }

    private static void main01() throws FileTreatmentException {
        println("Making root entries...");

        Directory rootDir = new Directory("root");
        Directory bitDir = new Directory("bit");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");

        rootDir.add(bitDir)
                .add(tmpDir)
                .add(usrDir);

        bitDir.add(new File("vi", 10000))
                .add(new File("latex", 20000));

        rootDir.accept(new ListVisitor());

        println("");
        println("Making user entries");

        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");

        usrDir.add(yuki)
                .add(hanako)
                .add(tomura);

        yuki.add(new File("diary.html", 100))
                .add(new File("Composite.java", 200));
        hanako.add(new File("memo.txt", 300));
        tomura.add(new File("game.doc", 400))
                .add(new File("junk.mail", 500));

        rootDir.accept(new ListVisitor());
    }

    private static void main02() throws FileTreatmentException {
        Directory rootDir = new Directory("root");
        Directory bitDir = new Directory("bit");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");

        rootDir.add(bitDir)
                .add(tmpDir)
                .add(usrDir);

        bitDir.add(new File("vi", 10000))
                .add(new File("latex", 20000));

        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");

        usrDir.add(yuki)
                .add(hanako)
                .add(tomura);

        yuki.add(new File("diary.html", 100))
                .add(new File("Composite.java", 200));
        hanako.add(new File("memo.txt", 300))
                .add(new File("index.html", 350));
        tomura.add(new File("game.doc", 400))
                .add(new File("junk.mail", 500));

        FileFindVisitor ffv = new FileFindVisitor(".html");
        rootDir.accept(ffv);

        println("HTML files are:");

        Iterator<File> iterator = ffv.getFoundFiles();
        while (iterator.hasNext()) {
            File file = iterator.next();
            println(file.toString());
        }
    }

    private static void main03() {
        Directory root1 = new Directory("root1");
        root1.add(new File("diary.html", 10));
        root1.add(new File("index.html", 20));

        Directory root2 = new Directory("root2");
        root2.add(new File("diary.html", 1000));
        root2.add(new File("index.html", 2000));

        ElementArrayList list = new ElementArrayList();
        list.add(root1);
        list.add(root2);
        list.add(new File("etc.html", 1234));

        list.accept(new ListVisitor());
    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static void startMain(String name) {
        println("*********** " + name + " ***********");
    }
}
