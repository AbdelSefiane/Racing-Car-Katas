package tddmicroexercises.turnticketdispenser;

public class TurnTicket {
    private final int turnNumber;

    private TurnTicket(int ticketNumber){
        this.turnNumber = ticketNumber;
    }

    public static TurnTicket getTurnTicket() {
        return new TurnTicket(TurnNumberSequence.getNextTurnNumber());
    }

    public int value() {
        return turnNumber;
    }

}
