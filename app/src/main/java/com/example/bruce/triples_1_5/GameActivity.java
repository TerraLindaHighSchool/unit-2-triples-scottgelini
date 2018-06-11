package com.example.bruce.triples_1_5;

import java.util.ArrayList;

public class GameActivity {
    private Deck deck;
    private ArrayList<Card> mCardOnBoard;
    private ArrayList<Integer> mSelectedCards;
    private long mStartTime;
    private int mNumOfCardsInDeck, mScore, mTriplesRemaining;

    public GameActivity(int numOfCardsInDeck, int level){
        mNumOfCardsInDeck = numOfCardsInDeck;
        mTriplesRemaining = numOfCardsInDeck / 3;
        deck = new Deck(numOfCardsInDeck);
        mCardOnBoard = new ArrayList<Card>();
        mSelectedCards = new ArrayList<Integer>();
    }

    /*************************************************
     * Getters and Setters
     *************************************************/

    protected Card getCardOnBoard(int index){
        return mCardOnBoard.get(index);
    }

    protected int getNumOfCardsSelected(){
        return mSelectedCards.size();
    }

    protected int getNumOfCardsInDeck(){
        return deck.getNumCardsInDeck();
    }

    protected int getSelectedCardIndex(int index){
        return mSelectedCards.get(index);
    }

    protected int getTriplesRemaining(){
        return mTriplesRemaining;
    }

    protected void setStartTime(){
        mStartTime = System.currentTimeMillis();
    }

    protected void setTriplesRemaining(){
        mTriplesRemaining--;
    }


    /*************************************************
     * Concrete Methods
     *************************************************/
    protected Card dealTopCard(int index){
        Card topCard = deck.getTopCard();
        if(index == -1) {                       // -1 means opening deal
            mCardOnBoard.add(topCard);
        }
        else {
            mCardOnBoard.set(index,topCard);
        }
        return topCard;
    }

    protected void listSelectedCards(boolean isSelected, int cardIndex){
        if(isSelected) mSelectedCards.add(cardIndex);
        else {
            for(int i = 0; i < mSelectedCards.size(); i++){
                int list = mSelectedCards.get(i);
                if(mSelectedCards.get(i) == cardIndex) mSelectedCards.remove(i);
        }}
    }

    protected void removeSelectedCard(int index){
        mSelectedCards.remove(index);
    }

    protected boolean isTriple(int firstCard, int secondCard, int thirdCard){
        boolean isTriple = false;
        if(mCardOnBoard.get(firstCard).getNumber() > 0
                && mCardOnBoard.get(secondCard).getNumber() > 0
                && mCardOnBoard.get(thirdCard).getNumber() > 0)
        {
            int num = mCardOnBoard.get(firstCard).getNumber() +
                    mCardOnBoard.get(secondCard).getNumber() +
                    mCardOnBoard.get(thirdCard).getNumber();
            int alpha = mCardOnBoard.get(firstCard).getAlpha() +
                    mCardOnBoard.get(secondCard).getAlpha() +
                    mCardOnBoard.get(thirdCard).getAlpha();
            int shape = mCardOnBoard.get(firstCard).getShape().ordinal() +
                    mCardOnBoard.get(secondCard).getShape().ordinal() +
                    mCardOnBoard.get(thirdCard).getShape().ordinal();
            int color = mCardOnBoard.get(firstCard).getColor().ordinal() +
                    mCardOnBoard.get(secondCard).getColor().ordinal() +
                    mCardOnBoard.get(thirdCard).getColor().ordinal();
            if(num % 3 == 0 && alpha % 3 == 0 && shape % 3 == 0 && color % 3 == 0) {
                isTriple = true;
            }
        }
        return isTriple;
    }

    protected boolean playIsPossible(){
        boolean isPossible = false;
        int firstCard = 0;
        int secondCard = 1;
        int thirdCard = 1;
        boolean allCardsChecked = false;
        while(!(isPossible || allCardsChecked)) {
            if (thirdCard < mCardOnBoard.size() - 1) thirdCard++;
            else {
                if (secondCard < mCardOnBoard.size() - 2) {
                    secondCard++;
                    thirdCard = secondCard + 1;
                } else {
                    if (firstCard < mCardOnBoard.size() - 3) {
                        firstCard++;
                        secondCard = firstCard + 1;
                        thirdCard = secondCard + 1;
                    }
                }
            }
            isPossible = isTriple(firstCard, secondCard, thirdCard);
            if(firstCard + secondCard + thirdCard == 3 * mCardOnBoard.size() - 6)   allCardsChecked = true;
        }
        return isPossible;
    }

    protected int updateScore() {
        long time = System.currentTimeMillis() - mStartTime;
        long scoreThisRound = 1000 - time / 10;
        if(scoreThisRound < 100) mScore += 100;
        else mScore += (int) scoreThisRound;
        return mScore;
    }
}
