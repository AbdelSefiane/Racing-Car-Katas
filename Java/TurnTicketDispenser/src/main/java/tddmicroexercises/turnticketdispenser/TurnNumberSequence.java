package tddmicroexercises.turnticketdispenser;

import java.util.concurrent.atomic.AtomicInteger;

public class TurnNumberSequence {
    private volatile static int _turnNumber = 0;

    public synchronized static int getNextTurnNumber() {
        return _turnNumber++;
    }
}
