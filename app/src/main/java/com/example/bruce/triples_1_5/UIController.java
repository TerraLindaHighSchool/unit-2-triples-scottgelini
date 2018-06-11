package com.example.bruce.triples_1_5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UIController extends AppCompatActivity {
    private final int MAX_IMAGES = 18;
    private ImageView[] mImageArray = new ImageView[MAX_IMAGES];
    private TextView mTextScore, mTextHighScore;
    private Button mButtonQuit;
    private GameActivity game;
    private Animation wobble, slideDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Get level from UI and assign number of cards on board and in deck
        int level = getIntent().getIntExtra("Level",1);
        int numCardsInDeck = 81;  // default cards in deck
        int numCardsOnBoard = 12; // default cards on board
        switch(level){
            case 1: numCardsOnBoard = 15;
                numCardsInDeck = 27;
                break;
            case 2: numCardsOnBoard = 12;
                numCardsInDeck = 27;
                break;
            case 3: numCardsOnBoard = 18;
                break;
            case 4: numCardsOnBoard = 15;;
                break;
            case 5: numCardsOnBoard = 12;
                break;
        }

        // set board features
        mTextScore = findViewById(R.id.TextView_Score);
        mTextHighScore = findViewById(R.id.TextView_High_Score);
        mButtonQuit = findViewById(R.id.Button_Quit);
        setImageArray();
        setAnimationsAndListener();
        game = new GameActivity(numCardsInDeck, level);
        beginGame(numCardsOnBoard);
        beginRound(numCardsOnBoard);
    }

    /*************************************************
     * Begin Game deals cards onto board
     *************************************************/
    private void beginGame(int numCardsOnBoard){
        updateAndDeclareScores(true);
        game.setStartTime();
        for(int i = numCardsOnBoard; i < MAX_IMAGES; i++)
            mImageArray[i].setVisibility(View.GONE);
        for(int imageIndex = 0; imageIndex < numCardsOnBoard; imageIndex++){
            mImageArray[imageIndex].setImageResource(game.dealTopCard(-1).getImageID());
        }
    }

    /*************************************************
     * Begin Round listens for user card selection
     *************************************************/
    protected void beginRound(int numCardsOnBoard) {
        for (int imageIndex = 0; imageIndex < numCardsOnBoard; imageIndex++) {
            final int index = imageIndex;
            mImageArray[imageIndex].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isSelecting;
                    Card cardSelected = game.getCardOnBoard(index);
        // Card already selected, so this unselects it ******************
                    if (cardSelected.getIsSelected()) {
                        mImageArray[index].setImageResource(cardSelected.getImageID());
                        cardSelected.setIsSelected(false);
                        game.listSelectedCards(false, index);
        // Card being selected  *******************************************
                    } else {
                        mImageArray[index].setImageResource(cardSelected.getSelectedImageID());
                        cardSelected.setIsSelected(true);
                        game.listSelectedCards(true, index);
                    }
        // Checks to see if 3 cards have been selected **************************
                    if (game.getNumOfCardsSelected() == 3)
                        endRound();
                }
            });
        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        }
    }

    /*************************************************
     * If triple, begins next round
     *************************************************/
    private void endRound(){
        int index;
        if (game.isTriple(game.getSelectedCardIndex(0), game.getSelectedCardIndex(1),
                          game.getSelectedCardIndex(2))) {
            for(int i = 3; i > 0; i--){
                index = game.getSelectedCardIndex(i - 1);
                if(game.getNumOfCardsInDeck() == 0) mImageArray[index].setVisibility(View.GONE);
                game.dealTopCard(index);
            }
            for(int i = 3; i > 0; i--){
                index = game.getSelectedCardIndex(i - 1);
                mImageArray[index].startAnimation(slideDown);
            }
            game.setTriplesRemaining();
            updateAndDeclareScores(false);
        }
        else {
            for(int i = 3; i > 0; i--){
                index = game.getSelectedCardIndex(i - 1);
                mImageArray[index].startAnimation(wobble);
                mImageArray[index].setImageResource(game.getCardOnBoard(index).getImageID());
                game.removeSelectedCard(i - 1);
            }
        }
    }

    /*************************************************
     * Misc Concrete Methods
     *************************************************/
    private void showToast(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }


    protected void updateAndDeclareScores(boolean isBegin) {
        SharedPreferences prefs = getSharedPreferences("Triples", MODE_PRIVATE);
        SharedPreferences.Editor editor;editor = prefs.edit();
        int highScore = prefs.getInt("High Score", 0);
        int currentScore = 0;
        if(!isBegin) currentScore = game.updateScore();
        String score = "Score: " + currentScore;
        mTextScore.setText(score);
        String highScoreStr = "Current High Score: " + highScore;
        if (currentScore > highScore) {
            editor.putInt("High Score", currentScore);
            editor.commit();
            highScoreStr = "Current High Score: " + currentScore;
        }
        mTextHighScore.setText(highScoreStr);
    }

    private void setImageArray(){
        mImageArray[0] = findViewById(R.id.imageView_0_0);
        mImageArray[1] = findViewById(R.id.imageView_0_1);
        mImageArray[2] = findViewById(R.id.imageView_0_2);
        mImageArray[3] = findViewById(R.id.imageView_1_0);
        mImageArray[4] = findViewById(R.id.imageView_1_1);
        mImageArray[5] = findViewById(R.id.imageView_1_2);
        mImageArray[6] = findViewById(R.id.imageView_2_0);
        mImageArray[7] = findViewById(R.id.imageView_2_1);
        mImageArray[8] = findViewById(R.id.imageView_2_2);
        mImageArray[9] = findViewById(R.id.imageView_3_0);
        mImageArray[10] = findViewById(R.id.imageView_3_1);
        mImageArray[11] = findViewById(R.id.imageView_3_2);
        mImageArray[12] = findViewById(R.id.imageView_4_0);
        mImageArray[13] = findViewById(R.id.imageView_4_1);
        mImageArray[14] = findViewById(R.id.imageView_4_2);
        mImageArray[15] = findViewById(R.id.imageView_5_0);
        mImageArray[16] = findViewById(R.id.imageView_5_1);
        mImageArray[17] = findViewById(R.id.imageView_5_2);
    }

    private void setAnimationsAndListener(){
        wobble = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.wobble);
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        slideDown.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                int index;
                for(int i = 3; i > 0; i--){
                    index = game.getSelectedCardIndex(i - 1);
                    mImageArray[index].setImageResource(game.getCardOnBoard(index).getImageID());
                    game.removeSelectedCard(i - 1);
                    game.setStartTime();
                }
                if(!game.playIsPossible()){
                    String endMsg = "      Game Over     ";
                    if(game.getTriplesRemaining() > 0)
                        endMsg +="\nPlay Is Not Possible";
                    showToast(endMsg);
                }
            };
        });
    }
}
