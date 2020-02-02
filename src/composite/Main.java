package composite;

public class Main {
    public static void main(String[] args) {
        try {
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

            rootDir.printList();

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

            rootDir.printList();

            println("");
            println("yuki = " + yuki.getFullName());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }

    public static void println(String s) {
        System.out.println(s);
    }
}
