package memento;

import memento.game.Gamer;
import memento.game.Memento;
import util.FilePathUtils;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = loadMemento();

        for (int i = 0; i < 100; i++) {
            println("==== " + i);
            println("現状: " + gamer);

            gamer.bet();

            println("所持金は" + gamer.getMoney() + "円になりました。");

            if ((memento == null) || (gamer.getMoney() > memento.getMoney())) {
                println("      (だいぶ増えたので、現在の状態を保存しておこう)");
                memento = gamer.createMemento();
                saveMemento(memento);
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                println("      (だいぶ減ったので、以前の状態に復帰しよう)");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
            println("");
        }
    }

    private static Memento loadMemento() {
        String path = FilePathUtils.getOutPath() + "game.dat";
        File game = new File(path);
        if (game.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
                Memento memento = (Memento) in.readObject();
                println("取得しました。 [" + memento + "]");
                return memento;
            } catch (IOException | ClassNotFoundException e) {
                println("取得に失敗しました。");
                return null;
            }
        }
        println("保存されているデータはありませんでした。");
        return null;
    }

    private static void saveMemento(Memento memento) {
        String path = FilePathUtils.getOutPath() + "game.dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(memento);
            out.flush();
            println("保存しました。 [" + memento + "] (" + path + ")");
        } catch (IOException e) {
            println("保存に失敗しました。");
        }
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
