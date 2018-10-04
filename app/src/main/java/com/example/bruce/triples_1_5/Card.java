package com.example.bruce.triples_1_5;

public class Card {
    protected enum Shape{Triangle, Square, Circle, NoShape}
    protected enum Color{Red, Green, Blue, NoColor}
    private Shape mShape;
    private Color mColor;
    private int mNumber, mAlpha, mImageID, mSelectedImageID;
    private boolean mIsSelected;

    Card(Shape shape, Color color, int number, int alpha, int imageID, int selectedImageID, boolean isSelected){
        mNumber = number;
        mAlpha = alpha;
        mShape = shape;
        mColor = color;
        mImageID = imageID;
        mSelectedImageID = selectedImageID;
        mIsSelected = isSelected;
    }

    protected Shape getShape(){
        return mShape;
    }

    protected Color getColor(){
        return mColor;
    }
    protected int getNumber(){
        return mNumber;
    }

    protected int getAlpha(){
        return mAlpha;
    }

    protected int getImageID(){
        return mImageID;
    }

    protected int getSelectedImageID(){
        return mSelectedImageID;
    }

    protected boolean getIsSelected(){
        return mIsSelected;
    }

    protected void setIsSelected(boolean s){
        mIsSelected = s;
    }
}


