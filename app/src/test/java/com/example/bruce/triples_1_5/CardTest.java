package com.example.bruce.triples_1_5;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getShape() {
        Card[] tim = {new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 2, 3, 4, 5),
                new Card(Card.Shape.SQUARE, Card.Color.BLUE, 2, 3,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5),
                new Card(Card.Shape.NO_SHAPE, Card.Color.BLUE, 2, 3,4,5)};
        Card.Shape[] s = {Card.Shape.CIRCLE,Card.Shape.SQUARE, Card.Shape.TRIANGLE, Card.Shape.NO_SHAPE};
        Card.Shape[] t = new Card.Shape[4];
        for (int i = 0; i < tim.length; i++) {
            t[i] = tim[i].getShape();
        }
        assertArrayEquals(s, t);
    }

    @Test
    public void getColor() {
        Card[] tim = {new Card(Card.Shape.TRIANGLE, Card.Color.RED, 2, 3,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 2, 3,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.NO_COLOR, 2, 3,4,5)};
        Card.Color[] s = {Card.Color.RED, Card.Color.BLUE, Card.Color.GREEN, Card.Color.NO_COLOR};
        Card.Color[] t = new Card.Color[4] ;
        for (int i = 0; i < tim.length; i++) {
            t[i] = tim[i].getColor();
        }
        assertArrayEquals(s, t);
    }

    @Test
    public void getAlpha() {
        Card[] tim = {new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 0, 1,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 1,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 1,4,5)};
        int[] s = {0, 1, 2};
        int[] t = new int [3];
        for (int i = 0; i < tim.length; i++) {
            t[i] = tim[i].getAlpha();
        }
        assertArrayEquals(s, t);
    }

    @Test
    public void getImageID() {
      Card tim = new Card (Card.Shape.TRIANGLE, Card.Color.BLUE,0,1, R.drawable.circle_blue_1_0,5);
      int s = R.drawable.circle_blue_1_0;
      int t = tim.getImageId();
      assertTrue (  s==t );



    }

    @Test
    public void getSelectedImageID() {

        Card tim = new Card (Card.Shape.TRIANGLE, Card.Color.BLUE,0,1, 4, R.drawable.triangle_blue_1_0);
        int s = R.drawable.triangle_blue_1_0;
        int t = tim.getSelectedImageId();
        assertTrue (  s==t );

    }



    @Test
    public void getIsSelected() {
        Card tim = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5);
        boolean s = false;
        boolean t = tim.getIsSelected();
        assertTrue(s == t);
    }

    @Test
    public void setIsSelected() {  Card tim = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5);
        tim.setIsSelected(true);
        boolean t = tim.getIsSelected();
        assertTrue(t == true);
    }

    @Test
    public void getNum()  {
        Card[] tim = {new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 1,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 2,4,5),
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 3,4,5)};
        int[] s = {1, 2, 3};
        int[] t = new int[3];
        for (int i = 0; i < tim.length; i++) {
            t[i] = tim[i].getNum();
        }
        assertArrayEquals(s, t);

    }

    @Test
    public void Test() {

    }
}
