package singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s1 == s2) {
            System.out.println("s1とs2は同じインスタンス");
        } else {
            System.out.println("s1とs2は異なるインスタンス");
        }
        System.out.println("End.");
    }
}
