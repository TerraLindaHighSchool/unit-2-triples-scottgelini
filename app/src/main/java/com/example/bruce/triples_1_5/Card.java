package com.example.bruce.triples_1_5;

public class Card {
private int mImage;
private int mselectedImage;
private int mNum;
private Shape mShape;
private Color mColor;
private int mImageId, mSelectedImageId;
private boolean mIsSelected;
private int mAlpha;
    public enum Shape {

     TRIANGLE, SQUARE, CIRCLE, NO_SHAPE
    }
    public enum Color {
        BLUE,RED,GREEN,NO_COLOR
    }

    public Shape getShape() {
        return mShape;
    }
    public Color getColor() {
        return mColor;
    }

        public int getImageId(){
        return mImageId;
        }

    public int getAlpha(){
        return mAlpha;
    }
public Card (Shape shape, Color color, int alpha, int num, int image, int selectedimage){
        mShape = shape;
        mColor = color;
        mAlpha = alpha;
        mNum = num;
        mImageId = image;
        mSelectedImageId = selectedimage;

}
    public int getSelectedImageId(){
        return mSelectedImageId;
    }
public void setIsSelected(boolean isSelected){
       this.mIsSelected = isSelected;

}

    public boolean getIsSelected() {
        return mIsSelected;
    }

    public int getNum(){
        return mNum;


    }



}














