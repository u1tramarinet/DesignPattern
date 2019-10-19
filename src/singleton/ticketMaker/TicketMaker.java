package singleton.ticketMaker;

public class TicketMaker {
    private static TicketMaker singleton = new TicketMaker();
    private int ticket;

    private TicketMaker() {
        this.ticket = 1000;
    }

    public static TicketMaker getInstance() {
        return singleton;
    }

    public int getNextTicketNumber() {
        return ticket++;
    }
}
