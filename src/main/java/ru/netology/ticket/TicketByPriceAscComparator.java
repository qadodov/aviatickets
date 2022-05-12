package ru.netology.ticket;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getDuration() - o2.getDuration();
    }
}
