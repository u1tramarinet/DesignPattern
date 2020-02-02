package strategy.janken;

public class Main {
    public static void main(String[] args) {
        boolean hasArgs = (args.length == 2);
        int seed1 = (hasArgs) ? Integer.parseInt(args[0]) : 314;
        int seed2 = (hasArgs) ? Integer.parseInt(args[1]) : 15;;

        Player player1 = new Player("Taro  ", new WinningStrategy(seed1));
        Player player2 = new Player("Hanako", new ProbStrategy(seed2));

        for (int i = 0; i < 10000; i++) {
            game(player1, player2);
        }

        println("Total result:");
        println(player1.toString());
        println(player2.toString());
    }

    private static void game(Player player1, Player player2) {
        Hand nextHand1 = player1.nextHand();
        Hand nextHand2 = player2.nextHand();

        if (nextHand1.isStrongerThan(nextHand2)) {
            println("Winner: " + player1);
            player1.win();
            player2.lose();
        } else if (nextHand2.isStrongerThan(nextHand1)) {
            println("Winner: " + player2);
            player1.lose();
            player2.win();
        } else {
            println("Even...");
            player1.even();
            player2.even();
        }
    }

    private static void println(String s) {
        System.out.println(s);
    }
}
