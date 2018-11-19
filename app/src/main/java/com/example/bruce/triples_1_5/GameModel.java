package com.example.bruce.triples_1_5;

import android.content.Context;
import java.util.ArrayList;

public class GameModel {
    private Deck deck;
    private ArrayList<Card> mCardOnBoard ;
    private ArrayList<Integer> mSelectedCards;
    private long mStartTime;
    private int mScore, mTriplesRemaining, mLevel, mNumOfCardsInDeck;



    GameModel(int numOfCardsInDeck, int level){
        deck = new Deck (numOfCardsInDeck);
        mNumOfCardsInDeck = numOfCardsInDeck;
        mLevel = level;
        mTriplesRemaining = numOfCardsInDeck / 3;
        mSelectedCards = new ArrayList<>();
        mCardOnBoard = new ArrayList<>();
        mStartTime = System.currentTimeMillis();
        mScore = 0;
        mNumOfCardsInDeck = numOfCardsInDeck;
    }

    /*************************************************
     * Getters and Setters
     *************************************************/

    public Card getCardOnBoard(int index) {
        return mCardOnBoard.get(index);
    }

    public int getNumOfCardsSelected(){
        return mSelectedCards.size();
    }

    public int getNumOfCardsInDeck(){
        return mNumOfCardsInDeck;
    }

    public int getSelectedCardIndex(int index){
        return mSelectedCards.get(index);
    }

    public void setStartTime(){
        mStartTime = System.currentTimeMillis();
    }

    public void setTriplesRemaining(){
        mTriplesRemaining--;
    }

    /*************************************************
     * Methods that place cards to board
     *************************************************/
    protected void addCardToBoard(){
        mCardOnBoard.add(deck.getTopCard());
    }

    protected void replaceCardOnBoard(int index){
        mCardOnBoard.set(index,deck.getTopCard());
    }

    /*************************************************
     * Methods that keep track of selected cards
     *************************************************/

    protected void addSelectedCardIndex(int cardIndex){
        mSelectedCards.add(cardIndex);
    }

    protected void removeSelectedCardIndex(int index){
        mSelectedCards.remove(new Integer(index));
    }

    protected void resetSelectedCardIndices(){
        int length = mSelectedCards.size();
        for(int i = length; i > 0; i--) {
            mSelectedCards.remove(i-1);
        }
    }

    /*************************************************
     * Scoring
     *************************************************/
    protected int updateScore() {
        long duration = System.currentTimeMillis() - mStartTime;

        if (duration > 30000) {
            duration = 30000;
        }
        mScore += 300 - duration / 300;
        return mScore;
    }

    /*************************************************
     * Methods that determine play
     *************************************************/

    protected boolean isTriple(int firstCard, int secondCard, int thirdCard){
        boolean shapeIsTriple = ((mCardOnBoard.get(firstCard).getShape().ordinal() + mCardOnBoard.get(secondCard).getShape().ordinal() + mCardOnBoard.get(thirdCard).getShape().ordinal()) % 3 == 0) ? true : false;

        boolean colorIsTriple =((mCardOnBoard.get(firstCard).getColor().ordinal() + mCardOnBoard.get(secondCard).getColor().ordinal() + mCardOnBoard.get(thirdCard).getColor().ordinal()) % 3 == 0) ? true : false;

        boolean alphaIsTriple = ((mCardOnBoard.get(firstCard).getAlpha() + mCardOnBoard.get(secondCard).getAlpha() + mCardOnBoard.get(thirdCard).getAlpha()) % 3 == 0) ? true : false;

        boolean numIsTriple = ((mCardOnBoard.get(firstCard).getNum() + mCardOnBoard.get(secondCard).getNum() + mCardOnBoard.get(thirdCard).getNum()) % 3 == 0) ? true : false;

        boolean isTriple = (shapeIsTriple == colorIsTriple && alphaIsTriple == numIsTriple && shapeIsTriple == alphaIsTriple) ? true : false ;

        return isTriple;
    }

    //protected boolean playIsPossible(){
     //   for (i = 0;   )
     //       return true;
    //}

    protected String getGameOverMessage(Context context){
        String message = context.getString(R.string.game_over);
        if(mTriplesRemaining > 0)
            message = "      " + message + "\n" + context.getString(R.string.play_not_possible);
        return message;
    }

}
