package com.example.bruce.triples_1_5;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private Card[] mOrderedDeck;
    private ArrayList<Card> mShuffledDeck;

    Deck(int numOfCardsInDeck){
        mOrderedDeck = new Card[numOfCardsInDeck + 1];
        populateOrderedDeckWithCards(numOfCardsInDeck);
        createShuffledDeck();
    }

    protected int getNumCardsInDeck(){
        return mShuffledDeck.size();
    }


    protected Card getTopCard(){
        Card topCard = mOrderedDeck[0];  //send blank card if deck empty *********
        if(mShuffledDeck.size() > 0) {
            topCard = mShuffledDeck.get(0);
            mShuffledDeck.remove(0);
        }
        return topCard;
    }

    private void createShuffledDeck(){
        int cardsInDeck = mOrderedDeck.length - 1;
        Random mRandom = new Random();
        mShuffledDeck = new ArrayList<>();
        for(int i = 0; i < cardsInDeck; i++) {
            mShuffledDeck.add(new Card(Card.Shape.NoShape,Card.Color.NoColor,0,0,
                    0,0, false));
        }
        int index = 1;
        while(index < cardsInDeck + 1){
            int moveTo = mRandom.nextInt(cardsInDeck);
            Card temp = mOrderedDeck[index];
            if(mShuffledDeck.get(moveTo).getNumber() == 0) {
                mShuffledDeck.set(moveTo, temp);
                index++;
            }
        }
    }

    private void populateOrderedDeckWithCards(int numOfCardsInDeck){
        mOrderedDeck[0] = new Card(Card.Shape.NoShape, Card.Color.NoColor,0,0,
                R.drawable.blank_0_0_0, R.drawable.blank_0_0_0,false);
        mOrderedDeck[1] = new Card(Card.Shape.Circle, Card.Color.Red,1,0,
                R.drawable.circle_red_1_0, R.drawable.circle_red_1_0_selected,false);
        mOrderedDeck[2] = new Card(Card.Shape.Circle, Card.Color.Red,2,0,
                R.drawable.circle_red_2_0, R.drawable.circle_red_2_0_selected,false);
        mOrderedDeck[3] = new Card(Card.Shape.Circle, Card.Color.Red,3,0,
                R.drawable.circle_red_3_0, R.drawable.circle_red_3_0_selected,false);
        mOrderedDeck[4] = new Card(Card.Shape.Circle, Card.Color.Green,1,0,
                R.drawable.circle_green_1_0, R.drawable.circle_green_1_0_selected,false);
        mOrderedDeck[5] = new Card(Card.Shape.Circle, Card.Color.Green,2,0,
                R.drawable.circle_green_2_0, R.drawable.circle_green_2_0_selected,false);
        mOrderedDeck[6] = new Card(Card.Shape.Circle, Card.Color.Green,3,0,
                R.drawable.circle_green_3_0, R.drawable.circle_green_3_0_selected,false);
        mOrderedDeck[7] = new Card(Card.Shape.Circle, Card.Color.Blue,1,0,
                R.drawable.circle_blue_1_0, R.drawable.circle_blue_1_0_selected,false);
        mOrderedDeck[8] = new Card(Card.Shape.Circle, Card.Color.Blue,2,0,
                R.drawable.circle_blue_2_0, R.drawable.circle_blue_2_0_selected,false);
        mOrderedDeck[9] = new Card(Card.Shape.Circle, Card.Color.Blue,3,0,
                R.drawable.circle_blue_3_0, R.drawable.circle_blue_3_0_selected,false);
        mOrderedDeck[10] = new Card(Card.Shape.Square, Card.Color.Red, 1, 0,
                R.drawable.square_red_1_0, R.drawable.square_red_1_0_selected, false);
        mOrderedDeck[11] = new Card(Card.Shape.Square, Card.Color.Red, 2, 0,
                R.drawable.square_red_2_0, R.drawable.square_red_2_0_selected, false);
        mOrderedDeck[12] = new Card(Card.Shape.Square, Card.Color.Red, 3, 0,
                R.drawable.square_red_3_0, R.drawable.square_red_3_0_selected, false);
        mOrderedDeck[13] = new Card(Card.Shape.Square, Card.Color.Green, 1, 0,
                R.drawable.square_green_1_0, R.drawable.square_green_1_0_selected, false);
        mOrderedDeck[14] = new Card(Card.Shape.Square, Card.Color.Green, 2, 0,
                R.drawable.square_green_2_0, R.drawable.square_green_2_0_selected, false);
        mOrderedDeck[15] = new Card(Card.Shape.Square, Card.Color.Green, 3, 0,
                R.drawable.square_green_3_0, R.drawable.square_green_3_0_selected, false);
        mOrderedDeck[16] = new Card(Card.Shape.Square, Card.Color.Blue, 1, 0,
                R.drawable.square_blue_1_0, R.drawable.square_blue_1_0_selected, false);
        mOrderedDeck[17] = new Card(Card.Shape.Square, Card.Color.Blue, 2, 0,
                R.drawable.square_blue_2_0, R.drawable.square_blue_2_0_selected, false);
        mOrderedDeck[18] = new Card(Card.Shape.Square, Card.Color.Blue, 3, 0,
                R.drawable.square_blue_3_0, R.drawable.square_blue_3_0_selected, false);
        mOrderedDeck[19] = new Card(Card.Shape.Triangle, Card.Color.Red, 1, 0,
                R.drawable.triangle_red_1_0, R.drawable.triangle_red_1_0_selected, false);
        mOrderedDeck[20] = new Card(Card.Shape.Triangle, Card.Color.Red, 2, 0,
                R.drawable.triangle_red_2_0, R.drawable.triangle_red_2_0_selected, false);
        mOrderedDeck[21] = new Card(Card.Shape.Triangle, Card.Color.Red, 3, 0,
                R.drawable.triangle_red_3_0, R.drawable.triangle_red_3_0_selected, false);
        mOrderedDeck[22] = new Card(Card.Shape.Triangle, Card.Color.Green, 1, 0,
                R.drawable.triangle_green_1_0, R.drawable.triangle_green_1_0_selected, false);
        mOrderedDeck[23] = new Card(Card.Shape.Triangle, Card.Color.Green, 2, 0,
                R.drawable.triangle_green_2_0, R.drawable.triangle_green_2_0_selected, false);
        mOrderedDeck[24] = new Card(Card.Shape.Triangle, Card.Color.Green, 3, 0,
                R.drawable.triangle_green_3_0, R.drawable.triangle_green_3_0_selected, false);
        mOrderedDeck[25] = new Card(Card.Shape.Triangle, Card.Color.Blue, 1, 0,
                R.drawable.triangle_blue_1_0, R.drawable.triangle_blue_1_0_selected, false);
        mOrderedDeck[26] = new Card(Card.Shape.Triangle, Card.Color.Blue, 2, 0,
                R.drawable.triangle_blue_2_0, R.drawable.triangle_blue_2_0_selected, false);
        mOrderedDeck[27] = new Card(Card.Shape.Triangle, Card.Color.Blue, 3, 0,
                R.drawable.triangle_blue_3_0, R.drawable.triangle_blue_3_0_selected, false);
        if(numOfCardsInDeck > 27) {
            mOrderedDeck[28] = new Card(Card.Shape.Circle, Card.Color.Red, 1, 1,
                    R.drawable.circle_red_1_1, R.drawable.circle_red_1_1_selected, false);
            mOrderedDeck[29] = new Card(Card.Shape.Circle, Card.Color.Red, 2, 1,
                    R.drawable.circle_red_2_1, R.drawable.circle_red_2_1_selected, false);
            mOrderedDeck[30] = new Card(Card.Shape.Circle, Card.Color.Red, 3, 1,
                    R.drawable.circle_red_3_1, R.drawable.circle_red_3_1_selected, false);
            mOrderedDeck[31] = new Card(Card.Shape.Circle, Card.Color.Green, 1, 1,
                    R.drawable.circle_green_1_1, R.drawable.circle_green_1_1_selected, false);
            mOrderedDeck[32] = new Card(Card.Shape.Circle, Card.Color.Green, 2, 1,
                    R.drawable.circle_green_2_1, R.drawable.circle_green_2_1_selected, false);
            mOrderedDeck[33] = new Card(Card.Shape.Circle, Card.Color.Green, 3, 1,
                    R.drawable.circle_green_3_1, R.drawable.circle_green_3_1_selected, false);
            mOrderedDeck[34] = new Card(Card.Shape.Circle, Card.Color.Blue, 1, 1,
                    R.drawable.circle_blue_1_1, R.drawable.circle_blue_1_1_selected, false);
            mOrderedDeck[35] = new Card(Card.Shape.Circle, Card.Color.Blue, 2, 1,
                    R.drawable.circle_blue_2_1, R.drawable.circle_blue_2_1_selected, false);
            mOrderedDeck[36] = new Card(Card.Shape.Circle, Card.Color.Blue, 3, 1,
                    R.drawable.circle_blue_3_1, R.drawable.circle_blue_3_1_selected, false);
            mOrderedDeck[37] = new Card(Card.Shape.Square, Card.Color.Red, 1, 1,
                    R.drawable.square_red_1_1, R.drawable.square_red_1_1_selected, false);
            mOrderedDeck[38] = new Card(Card.Shape.Square, Card.Color.Red, 2, 1,
                    R.drawable.square_red_2_1, R.drawable.square_red_2_1_selected, false);
            mOrderedDeck[39] = new Card(Card.Shape.Square, Card.Color.Red, 3, 1,
                    R.drawable.square_red_3_1, R.drawable.square_red_3_1_selected, false);
            mOrderedDeck[40] = new Card(Card.Shape.Square, Card.Color.Green, 1, 1,
                    R.drawable.square_green_1_1, R.drawable.square_green_1_1_selected, false);
            mOrderedDeck[41] = new Card(Card.Shape.Square, Card.Color.Green, 2, 1,
                    R.drawable.square_green_2_1, R.drawable.square_green_2_1_selected, false);
            mOrderedDeck[42] = new Card(Card.Shape.Square, Card.Color.Green, 3, 1,
                    R.drawable.square_green_3_1, R.drawable.square_green_3_1_selected, false);
            mOrderedDeck[43] = new Card(Card.Shape.Square, Card.Color.Blue, 1, 1,
                    R.drawable.square_blue_1_1, R.drawable.square_blue_1_1_selected, false);
            mOrderedDeck[44] = new Card(Card.Shape.Square, Card.Color.Blue, 2, 1,
                    R.drawable.square_blue_2_1, R.drawable.square_blue_2_1_selected, false);
            mOrderedDeck[45] = new Card(Card.Shape.Square, Card.Color.Blue, 3, 1,
                    R.drawable.square_blue_3_1, R.drawable.square_blue_3_1_selected, false);
            mOrderedDeck[46] = new Card(Card.Shape.Triangle, Card.Color.Red, 1, 1,
                    R.drawable.triangle_red_1_1, R.drawable.triangle_red_1_1_selected, false);
            mOrderedDeck[47] = new Card(Card.Shape.Triangle, Card.Color.Red, 2, 1,
                    R.drawable.triangle_red_2_1, R.drawable.triangle_red_2_1_selected, false);
            mOrderedDeck[48] = new Card(Card.Shape.Triangle, Card.Color.Red, 3, 1,
                    R.drawable.triangle_red_3_1, R.drawable.triangle_red_3_1_selected, false);
            mOrderedDeck[49] = new Card(Card.Shape.Triangle, Card.Color.Green, 1, 1,
                    R.drawable.triangle_green_1_1, R.drawable.triangle_green_1_1_selected, false);
            mOrderedDeck[50] = new Card(Card.Shape.Triangle, Card.Color.Green, 2, 1,
                    R.drawable.triangle_green_2_1, R.drawable.triangle_green_2_1_selected, false);
            mOrderedDeck[51] = new Card(Card.Shape.Triangle, Card.Color.Green, 3, 1,
                    R.drawable.triangle_green_3_1, R.drawable.triangle_green_3_1_selected, false);
            mOrderedDeck[52] = new Card(Card.Shape.Triangle, Card.Color.Blue, 1, 1,
                    R.drawable.triangle_blue_1_1, R.drawable.triangle_blue_1_1_selected, false);
            mOrderedDeck[53] = new Card(Card.Shape.Triangle, Card.Color.Blue, 2, 1,
                    R.drawable.triangle_blue_2_1, R.drawable.triangle_blue_2_1_selected, false);
            mOrderedDeck[54] = new Card(Card.Shape.Triangle, Card.Color.Blue, 3, 1,
                    R.drawable.triangle_blue_3_1, R.drawable.triangle_blue_3_1_selected, false);
        }
        if(numOfCardsInDeck > 54) {
            mOrderedDeck[55] = new Card(Card.Shape.Circle, Card.Color.Red, 1, 2,
                    R.drawable.circle_red_1_2, R.drawable.circle_red_1_2_selected, false);
            mOrderedDeck[56] = new Card(Card.Shape.Circle, Card.Color.Red, 2, 2,
                    R.drawable.circle_red_2_2, R.drawable.circle_red_2_2_selected, false);
            mOrderedDeck[57] = new Card(Card.Shape.Circle, Card.Color.Red, 3, 2,
                    R.drawable.circle_red_3_2, R.drawable.circle_red_3_2_selected, false);
            mOrderedDeck[58] = new Card(Card.Shape.Circle, Card.Color.Green, 1, 2,
                    R.drawable.circle_green_1_2, R.drawable.circle_green_1_2_selected, false);
            mOrderedDeck[59] = new Card(Card.Shape.Circle, Card.Color.Green, 2, 2,
                    R.drawable.circle_green_2_2, R.drawable.circle_green_2_2_selected, false);
            mOrderedDeck[60] = new Card(Card.Shape.Circle, Card.Color.Green, 3, 2,
                    R.drawable.circle_green_3_2, R.drawable.circle_green_3_2_selected, false);
            mOrderedDeck[61] = new Card(Card.Shape.Circle, Card.Color.Blue, 1, 2,
                    R.drawable.circle_blue_1_2, R.drawable.circle_blue_1_2_selected, false);
            mOrderedDeck[62] = new Card(Card.Shape.Circle, Card.Color.Blue, 2, 2,
                    R.drawable.circle_blue_2_2, R.drawable.circle_blue_2_2_selected, false);
            mOrderedDeck[63] = new Card(Card.Shape.Circle, Card.Color.Blue, 3, 2,
                    R.drawable.circle_blue_3_2, R.drawable.circle_blue_3_2_selected, false);
            mOrderedDeck[64] = new Card(Card.Shape.Square, Card.Color.Red, 1, 2,
                    R.drawable.square_red_1_2, R.drawable.square_red_1_2_selected, false);
            mOrderedDeck[65] = new Card(Card.Shape.Square, Card.Color.Red, 2, 2,
                    R.drawable.square_red_2_2, R.drawable.square_red_2_2_selected, false);
            mOrderedDeck[66] = new Card(Card.Shape.Square, Card.Color.Red, 3, 2,
                    R.drawable.square_red_3_2, R.drawable.square_red_3_2_selected, false);
            mOrderedDeck[67] = new Card(Card.Shape.Square, Card.Color.Green, 1, 2,
                    R.drawable.square_green_1_2, R.drawable.square_green_1_2_selected, false);
            mOrderedDeck[68] = new Card(Card.Shape.Square, Card.Color.Green, 2, 2,
                    R.drawable.square_green_2_2, R.drawable.square_green_2_2_selected, false);
            mOrderedDeck[69] = new Card(Card.Shape.Square, Card.Color.Green, 3, 2,
                    R.drawable.square_green_3_2, R.drawable.square_green_3_2_selected, false);
            mOrderedDeck[70] = new Card(Card.Shape.Square, Card.Color.Blue, 1, 2,
                    R.drawable.square_blue_1_2, R.drawable.square_blue_1_2_selected, false);
            mOrderedDeck[71] = new Card(Card.Shape.Square, Card.Color.Blue, 2, 2,
                    R.drawable.square_blue_2_2, R.drawable.square_blue_2_2_selected, false);
            mOrderedDeck[72] = new Card(Card.Shape.Square, Card.Color.Blue, 3, 2,
                    R.drawable.square_blue_3_2, R.drawable.square_blue_3_2_selected, false);
            mOrderedDeck[73] = new Card(Card.Shape.Triangle, Card.Color.Red, 1, 2,
                    R.drawable.triangle_red_1_2, R.drawable.triangle_red_1_2_selected, false);
            mOrderedDeck[74] = new Card(Card.Shape.Triangle, Card.Color.Red, 2, 2,
                    R.drawable.triangle_red_2_2, R.drawable.triangle_red_2_2_selected, false);
            mOrderedDeck[75] = new Card(Card.Shape.Triangle, Card.Color.Red, 3, 2,
                    R.drawable.triangle_red_3_2, R.drawable.triangle_red_3_2_selected, false);
            mOrderedDeck[76] = new Card(Card.Shape.Triangle, Card.Color.Green, 1, 2,
                    R.drawable.triangle_green_1_2, R.drawable.triangle_green_1_2_selected, false);
            mOrderedDeck[77] = new Card(Card.Shape.Triangle, Card.Color.Green, 2, 2,
                    R.drawable.triangle_green_2_2, R.drawable.triangle_green_2_2_selected, false);
            mOrderedDeck[78] = new Card(Card.Shape.Triangle, Card.Color.Green, 3, 2,
                    R.drawable.triangle_green_3_2, R.drawable.triangle_green_3_2_selected, false);
            mOrderedDeck[79] = new Card(Card.Shape.Triangle, Card.Color.Blue, 1, 2,
                    R.drawable.triangle_blue_1_2, R.drawable.triangle_blue_1_2_selected, false);
            mOrderedDeck[80] = new Card(Card.Shape.Triangle, Card.Color.Blue, 2, 2,
                    R.drawable.triangle_blue_2_2, R.drawable.triangle_blue_2_2_selected, false);
            mOrderedDeck[81] = new Card(Card.Shape.Triangle, Card.Color.Blue, 3, 2,
                    R.drawable.triangle_blue_3_2, R.drawable.triangle_blue_3_2_selected, false);
        }
    }
}
