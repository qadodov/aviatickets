package ru.netology.repository;

import ru.netology.ticket.Ticket;

public class Repository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }
}
