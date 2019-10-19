package singleton.ticketMaker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        TicketMaker tk1 = TicketMaker.getInstance();
        TicketMaker tk2 = TicketMaker.getInstance();
        TicketMaker tk3 = TicketMaker.getInstance();

        System.out.println("tk1のチケット番号は" + tk1.getNextTicketNumber());
        System.out.println("tk2のチケット番号は" + tk2.getNextTicketNumber());
        System.out.println("tk3のチケット番号は" + tk3.getNextTicketNumber());

        System.out.println("End.");
    }
}
