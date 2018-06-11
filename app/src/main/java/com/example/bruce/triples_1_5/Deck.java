package com.example.bruce.triples_1_5;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private Card[] mOrderedDeck;
    private ArrayList<Card> mShuffledDeck;

    protected Deck(int numOfCardsInDeck){
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
        mShuffledDeck = new ArrayList<Card>();
        for(int i = 0; i < cardsInDeck; i++) {
            mShuffledDeck.add(new Card(Card.Shape.mNoShape,Card.Color.mNoColor,0,0,
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

    private void populateOrderedDeckWithCards(int cardsInDeck){
        mOrderedDeck[0] = new Card(Card.Shape.mNoShape, Card.Color.mNoColor,0,0,
                R.drawable.blank_0_0_0, R.drawable.blank_0_0_0,false);
        mOrderedDeck[1] = new Card(Card.Shape.mCircle, Card.Color.mRed,1,0,
                R.drawable.circle_red_1_0, R.drawable.circle_red_1_0_selected,false);
        mOrderedDeck[2] = new Card(Card.Shape.mCircle, Card.Color.mRed,2,0,
                R.drawable.circle_red_2_0, R.drawable.circle_red_2_0_selected,false);
        mOrderedDeck[3] = new Card(Card.Shape.mCircle, Card.Color.mRed,3,0,
                R.drawable.circle_red_3_0, R.drawable.circle_red_3_0_selected,false);
        mOrderedDeck[4] = new Card(Card.Shape.mCircle, Card.Color.mGreen,1,0,
                R.drawable.circle_green_1_0, R.drawable.circle_green_1_0_selected,false);
        mOrderedDeck[5] = new Card(Card.Shape.mCircle, Card.Color.mGreen,2,0,
                R.drawable.circle_green_2_0, R.drawable.circle_green_2_0_selected,false);
        mOrderedDeck[6] = new Card(Card.Shape.mCircle, Card.Color.mGreen,3,0,
                R.drawable.circle_green_3_0, R.drawable.circle_green_3_0_selected,false);
        mOrderedDeck[7] = new Card(Card.Shape.mCircle, Card.Color.mBlue,1,0,
                R.drawable.circle_blue_1_0, R.drawable.circle_blue_1_0_selected,false);
        mOrderedDeck[8] = new Card(Card.Shape.mCircle, Card.Color.mBlue,2,0,
                R.drawable.circle_blue_2_0, R.drawable.circle_blue_2_0_selected,false);
        mOrderedDeck[9] = new Card(Card.Shape.mCircle, Card.Color.mBlue,3,0,
                R.drawable.circle_blue_3_0, R.drawable.circle_blue_3_0_selected,false);
        mOrderedDeck[10] = new Card(Card.Shape.mSquare, Card.Color.mRed, 1, 0,
                R.drawable.square_red_1_0, R.drawable.square_red_1_0_selected, false);
        mOrderedDeck[11] = new Card(Card.Shape.mSquare, Card.Color.mRed, 2, 0,
                R.drawable.square_red_2_0, R.drawable.square_red_2_0_selected, false);
        mOrderedDeck[12] = new Card(Card.Shape.mSquare, Card.Color.mRed, 3, 0,
                R.drawable.square_red_3_0, R.drawable.square_red_3_0_selected, false);
        mOrderedDeck[13] = new Card(Card.Shape.mSquare, Card.Color.mGreen, 1, 0,
                R.drawable.square_green_1_0, R.drawable.square_green_1_0_selected, false);
        mOrderedDeck[14] = new Card(Card.Shape.mSquare, Card.Color.mGreen, 2, 0,
                R.drawable.square_green_2_0, R.drawable.square_green_2_0_selected, false);
        mOrderedDeck[15] = new Card(Card.Shape.mSquare, Card.Color.mGreen, 3, 0,
                R.drawable.square_green_3_0, R.drawable.square_green_3_0_selected, false);
        mOrderedDeck[16] = new Card(Card.Shape.mSquare, Card.Color.mBlue, 1, 0,
                R.drawable.square_blue_1_0, R.drawable.square_blue_1_0_selected, false);
        mOrderedDeck[17] = new Card(Card.Shape.mSquare, Card.Color.mBlue, 2, 0,
                R.drawable.square_blue_2_0, R.drawable.square_blue_2_0_selected, false);
        mOrderedDeck[18] = new Card(Card.Shape.mSquare, Card.Color.mBlue, 3, 0,
                R.drawable.square_blue_3_0, R.drawable.square_blue_3_0_selected, false);
        mOrderedDeck[19] = new Card(Card.Shape.mTriangle, Card.Color.mRed, 1, 0,
                R.drawable.triangle_red_1_0, R.drawable.triangle_red_1_0_selected, false);
        mOrderedDeck[20] = new Card(Card.Shape.mTriangle, Card.Color.mRed, 2, 0,
                R.drawable.triangle_red_2_0, R.drawable.triangle_red_2_0_selected, false);
        mOrderedDeck[21] = new Card(Card.Shape.mTriangle, Card.Color.mRed, 3, 0,
                R.drawable.triangle_red_3_0, R.drawable.triangle_red_3_0_selected, false);
        mOrderedDeck[22] = new Card(Card.Shape.mTriangle, Card.Color.mGreen, 1, 0,
                R.drawable.triangle_green_1_0, R.drawable.triangle_green_1_0_selected, false);
        mOrderedDeck[23] = new Card(Card.Shape.mTriangle, Card.Color.mGreen, 2, 0,
                R.drawable.triangle_green_2_0, R.drawable.triangle_green_2_0_selected, false);
        mOrderedDeck[24] = new Card(Card.Shape.mTriangle, Card.Color.mGreen, 3, 0,
                R.drawable.triangle_green_3_0, R.drawable.triangle_green_3_0_selected, false);
        mOrderedDeck[25] = new Card(Card.Shape.mTriangle, Card.Color.mBlue, 1, 0,
                R.drawable.triangle_blue_1_0, R.drawable.triangle_blue_1_0_selected, false);
        mOrderedDeck[26] = new Card(Card.Shape.mTriangle, Card.Color.mBlue, 2, 0,
                R.drawable.triangle_blue_2_0, R.drawable.triangle_blue_2_0_selected, false);
        mOrderedDeck[27] = new Card(Card.Shape.mTriangle, Card.Color.mBlue, 3, 0,
                R.drawable.triangle_blue_3_0, R.drawable.triangle_blue_3_0_selected, false);
    }
}
