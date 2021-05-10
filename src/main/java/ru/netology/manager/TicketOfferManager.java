package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;
import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor

public class TicketOfferManager {
    private TicketOfferRepository repository;

    public void add(TicketOffer item) {
        repository.save(item);
    }

    public TicketOffer[] findAll(String from, String to) {
        TicketOffer[] ticketOffers = repository.findAll();
        TicketOffer[] result = new TicketOffer[0];
        int count = 0;
        for (TicketOffer ticketOffer : ticketOffers) {
            if (ticketOffer.getDepartureAirport().equalsIgnoreCase(from) && ticketOffer.getArrivalAirport().equalsIgnoreCase(to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[count] = ticketOffer;
                count++;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public TicketOffer[] findAllWithComparator(String from, String to, Comparator<TicketOffer> comparator) {
        TicketOffer[] ticketOffers = repository.findAll();
        TicketOffer[] result = new TicketOffer[0];
        int count = 0;
        for (TicketOffer ticketOffer : ticketOffers) {
            if (ticketOffer.getDepartureAirport().equalsIgnoreCase(from) && ticketOffer.getArrivalAirport().equalsIgnoreCase(to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[count] = ticketOffer;
                count++;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}


