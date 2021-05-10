package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.domain.TicketOfferWithComparator;
import ru.netology.repository.TicketOfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfferManagerTest {
    private TicketOfferRepository repository = new TicketOfferRepository();
    private TicketOfferManager manager = new TicketOfferManager(repository);

    private TicketOffer ticketOffer1 = new TicketOffer(1, 4201, "KUF", "SIP", 165);
    private TicketOffer ticketOffer2 = new TicketOffer(2, 7002, "GOJ", "SVX", 115);
    private TicketOffer ticketOffer3 = new TicketOffer(3, 5139, "DME", "ULV", 85);
    private TicketOffer ticketOffer4 = new TicketOffer(4, 6141, "VKO", "KXK", 125);
    private TicketOffer ticketOffer5 = new TicketOffer(5, 8532, "SVO", "SKX", 500);
    private TicketOffer ticketOffer6 = new TicketOffer(6, 3932, "KUF", "SIP", 185);
    private TicketOffer ticketOffer7 = new TicketOffer(7, 5012, "KUF", "SIP", 265);
    private TicketOffer ticketOffer8 = new TicketOffer(8, 9018, "SVO", "SKX", 510);


    @BeforeEach
    public void setUp() {
        manager.add(ticketOffer1);
        manager.add(ticketOffer2);
        manager.add(ticketOffer3);
        manager.add(ticketOffer4);
        manager.add(ticketOffer5);
        manager.add(ticketOffer6);
        manager.add(ticketOffer7);
        manager.add(ticketOffer8);
    }

    @Test
    void shouldFind() {
        TicketOffer[] expected = new TicketOffer[]{ticketOffer5, ticketOffer8};
        TicketOffer[] actual = manager.findAll("SVO", "SKX");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNoFind() {
        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = manager.findAll("GOJ", "GOJ");

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindAndSortingByPrice() {
        TicketOffer[] expected = new TicketOffer[]{ticketOffer6, ticketOffer1, ticketOffer7};
        TicketOffer[] actual = manager.findAll("KUF", "SIP");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAndSortByTravelTime() {
        TicketOfferWithComparator ticketOfferWithComparator = new TicketOfferWithComparator();
        TicketOffer[] expected = new TicketOffer[]{ticketOffer1, ticketOffer6, ticketOffer7};
        TicketOffer[] actual = manager.findAllWithComparator("KUF", "SIP", ticketOfferWithComparator);
        assertArrayEquals(expected, actual);
    }
}