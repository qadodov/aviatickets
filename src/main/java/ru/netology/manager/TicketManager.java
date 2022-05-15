package ru.netology.manager;

import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;
import ru.netology.ticket.TicketByPriceAscComparator;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private Repository repository;

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public TicketManager(Repository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesFrom(ticket, from)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Ticket[] finalResult = new Ticket[0];
        for (Ticket ticket : result) {
            if (matchesTo(ticket, to)) {
                Ticket[] tmpSecond = new Ticket[finalResult.length + 1];
                for (int i = 0; i < finalResult.length; i++) {
                    tmpSecond[i] = finalResult[i];
                }
                tmpSecond[tmpSecond.length - 1] = ticket;
                finalResult = tmpSecond;
            }
        }
        Arrays.sort(finalResult);
        return finalResult;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesFrom(ticket, from)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Ticket[] finalResult = new Ticket[0];
        for (Ticket ticket : result) {
            if (matchesTo(ticket, to)) {
                Ticket[] tmpSecond = new Ticket[finalResult.length + 1];
                for (int i = 0; i < finalResult.length; i++) {
                    tmpSecond[i] = finalResult[i];
                }
                tmpSecond[tmpSecond.length - 1] = ticket;
                finalResult = tmpSecond;
            }
        }
        Arrays.sort(finalResult, new TicketByPriceAscComparator());
        return finalResult;
    }

    public boolean matchesFrom(Ticket ticket, String search) {
        return ticket.getDepartureAirport().contains(search);
    }

    public boolean matchesTo(Ticket ticket, String search) {
        return ticket.getArrivalAirport().contains(search);
    }

}
