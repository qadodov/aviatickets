package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    Ticket t1 = new Ticket(1, 1500, "DME", "GZP", 150);
    Ticket t2 = new Ticket(2, 5000, "DME", "EGO", 120);
    Ticket t3 = new Ticket(3, 2000, "AAQ", "GZP", 200);
    Ticket t4 = new Ticket(4, 1000, "DME", "EGO", 400);
    Ticket t5 = new Ticket(5, 7000, "DYU", "KEJ", 300);
    Ticket t6 = new Ticket(6, 5000, "VKO", "DLP", 250);
    Ticket t7 = new Ticket(7, 3700, "DME", "ROM", 180);
    Ticket t8 = new Ticket(8, 4200, "DME", "EGO", 215);
    Ticket t9 = new Ticket(9, 6000, "DME", "EGO", 185);
    Ticket t10 = new Ticket(10, 7000, "DME", "EGO", 190);

    Repository repo = new Repository();
    TicketManager manager = new TicketManager(repo);


    @Test
    void shouldSortSelectedTicketsByDuration() {

        manager.add(t10);
        manager.add(t7);
        manager.add(t8);
        manager.add(t3);
        manager.add(t9);
        manager.add(t6);
        manager.add(t4);
        manager.add(t2);


        Ticket[] expected = {t2, t9, t10, t8, t4};
        Ticket[] actual = manager.findAll("DME", "EGO", Ticket::compareTo);


        assertArrayEquals(expected, actual);
    }
}