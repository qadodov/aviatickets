package ru.netology.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int duration;

    @Override
    public int compareTo(Ticket o) {
        Ticket ticket = o;
        return this.price - ticket.price;
    }
}
