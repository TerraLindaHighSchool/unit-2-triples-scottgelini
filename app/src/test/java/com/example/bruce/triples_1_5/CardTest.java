package com.example.bruce.triples_1_5;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getShape() {
        Card[] card = {new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 2, 3, 4, 5),
                new Card(Card.Shape.SQUARE, Card.Color.BLUE, 2, 3,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5),
                new Card(Card.Shape.NO_SHAPE, Card.Color.BLUE, 2, 3,4,5)};
        Card.Shape[] expected = {Card.Shape.CIRCLE,Card.Shape.SQUARE, Card.Shape.TRIANGLE, Card.Shape.NO_SHAPE};
        Card.Shape[] actual = new Card.Shape[4];
        for (int i = 0; i < card.length; i++) {
            actual[i] = card[i].getShape();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getColor() {
        Card[] card = {new Card(Card.Shape.TRIANGLE, Card.Color.RED, 2, 3,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 2, 3,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.NO_COLOR, 2, 3,4,5)};
        Card.Color[] expected = {Card.Color.RED, Card.Color.BLUE, Card.Color.GREEN, Card.Color.NO_COLOR};
        Card.Color[] actual = new Card.Color[4] ;
        for (int i = 0; i < card.length; i++) {
            actual[i] = card[i].getColor();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAlpha() {
        Card[] card = {new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 0, 1,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 1,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 1,4,5)};
        int[] expected = {0, 1, 2};
        int[] actual = new int [3];
        for (int i = 0; i < card.length; i++) {
            actual[i] = card[i].getAlpha();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getImageID() {
      Card card = new Card (Card.Shape.TRIANGLE, Card.Color.BLUE,0,1, R.drawable.circle_blue_1_0,5);
      int expected = R.drawable.circle_blue_1_0;
      int actual = card.getImageId();
      assertTrue (  expected==actual );



    }

    @Test
    public void getSelectedImageID() {

        Card card = new Card (Card.Shape.TRIANGLE, Card.Color.BLUE,0,1, 4, R.drawable.triangle_blue_1_0);
        int expected = R.drawable.triangle_blue_1_0;
        int actual = card.getSelectedImageId();
        assertTrue (  expected==actual );

    }



    @Test
    public void getIsSelected() {
        Card card = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5);
        boolean expected = false;
        boolean actual = card.getIsSelected();
        assertTrue(expected == actual);
    }

    @Test
    public void setIsSelected() {  Card card = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5);
        card.setIsSelected(true);
        boolean actual = card.getIsSelected();
        assertTrue(actual == true);
    }

    @Test
    public void getNum()  {
        Card[] card = {new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 1,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 2,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5)};
        int[] expected = {1, 2, 3};
        int[] actual = new int[3];
        for (int i = 0; i < card.length; i++) {
            actual[i] = card[i].getNum();
        }
        assertArrayEquals(expected, actual);

    }

    @Test
    public void Test() {

    }
}
