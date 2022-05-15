package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.ticket.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    Ticket t1 = new Ticket(1, 1500, "DME", "GZP", 150);
    Ticket t2 = new Ticket(2, 5000, "DME", "EGO", 120);
    Ticket t3 = new Ticket(3, 2000, "AAQ", "GZP", 200);
    Ticket t4 = new Ticket(4, 1000, "DME", "EGO", 120);

    Repository repo = new Repository();
    TicketManager manager = new TicketManager(repo);

    @Test
    void shouldSelectTicketsThatMatch() {

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);

        Ticket[] expected = {t4, t2};
        Ticket[] actual = manager.findAll("DME", "EGO");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSort() {

        Ticket[] expected = new Ticket[]{t4, t1, t3, t2};
        Ticket[] actual = new Ticket[]{t4, t2, t1, t3};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

}