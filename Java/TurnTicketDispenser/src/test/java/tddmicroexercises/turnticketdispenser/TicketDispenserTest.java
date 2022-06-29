package tddmicroexercises.turnticketdispenser;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

class TicketDispenserTest {
    @Test
    void getTurnTicketShouldGetTurnTicket() {
        TicketDispenser dispenser = new TicketDispenser();
        TurnTicket ticket = dispenser.getTurnTicket();
        assertEquals(0, ticket.value());
    }

    @Test
    void getTurnTicketShouldGetSuccessiveTicketNumbers() {
        TicketDispenser dispenser = new TicketDispenser();
        TurnTicket ticket = dispenser.getTurnTicket();
        TurnTicket ticket2 = dispenser.getTurnTicket();
        assertEquals(1, ticket.value());
        assertEquals(ticket.value() + 1, ticket2.value());
    }

    @Test
    void getTurnTicketShouldGetSuccessiveTicketNumbersInParallelExecution() throws ExecutionException, InterruptedException {
        final int nbThreads = 1000;
        TicketDispenser dispenser = new TicketDispenser();
        Set<Integer> count = new HashSet<>();
        ExecutorService service = Executors.newFixedThreadPool(nbThreads);
        final CountDownLatch flipflop = new CountDownLatch(1);
        List<Future<TurnTicket>> array = new ArrayList<Future<TurnTicket>>();
        for (int i = 0; i < nbThreads; i++) {
            array.add(service.submit(() -> {
                flipflop.await();
                return dispenser.getTurnTicket();
            }));
        }
        flipflop.countDown();
        for (int i = 0; i < nbThreads; i++) {
            count.add(array.get(i).get().value());
        }
        assertEquals(nbThreads, count.size());

    }
}
