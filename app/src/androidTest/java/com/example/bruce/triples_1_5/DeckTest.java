package com.example.bruce.triples_1_5;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck;

    @Before
    public void setUp(){
        deck = new Deck(81);
    }

    @Test
    public void getNumCardsInDeck() {
        int expected = 81;
        int actual = deck.getNumCardsInDeck();
        assertTrue(expected == actual);
    }

    @Test
    public void getTopCard() {
        Card expected = deck.getCard(0);
        Card actual = deck.getTopCard();
        assertTrue(expected.equals(actual));
    }

    @Test
    public void createShuffledDeck() {
        Card topCard;
        Card nextCard;
        for(int i = 0; i < 40; i++) {
            topCard = deck.getTopCard();
            nextCard = deck.getTopCard();
            assertTrue(!topCard.equals(nextCard));
        }

    }
}
