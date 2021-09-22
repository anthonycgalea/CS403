package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    boolean[] guesses;
    ArrayList<String> wordList;
    String currentWord;
    final int maxGuesses=6;
    int incorrectGuesses;
    ImageView hManImage;
    TextView txtBoard;
    String guessHistory;
    TextView txtGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadAssets();
        startNewGame();
        this.hManImage = (ImageView) findViewById(R.id.hManImage);
        this.txtBoard = (TextView) findViewById(R.id.txtBoard);
        this.txtGuess = (TextView) findViewById(R.id.txtGuessLetter);
    }

    public void loadAssets() {
        InputStream is = getResources().openRawResource(R.raw.wordlist10000);
        Scanner sc = new Scanner(is);
        while(!sc.hasNext()) {
            wordList.add(sc.nextLine());
        }
    }

    public void startNewGame() {
        Random rand = new Random();
        int wordNum = rand.nextInt(wordList.size()-1);
        this.currentWord=this.wordList.get(wordNum);
        this.guesses=new boolean[this.currentWord.length()];
        for (int i =0; i < this.guesses.length; i++) {
            this.guesses[i]=false;
        }
        this.incorrectGuesses =0;
        this.guessHistory = "";
        updateBoard();
    }

    public boolean isSolved() {
        for (int i = 0; i < this.guesses.length; i++) {
            if (this.guesses[i] == false) {
                return false;
            }
        }
        return true;
    }

    public void updateBoard() {
        this.txtBoard.setText(getBoardText());
        sethManImage();
    }

    public void sethManImage() {
        switch(incorrectGuesses) {
            case 1:
                this.hManImage.setImageResource(R.drawable.hangman1);
                break;
            case 2:
                this.hManImage.setImageResource(R.drawable.hangman2);
                break;
            case 3:
                this.hManImage.setImageResource(R.drawable.hangman3);
                break;
            case 4:
                this.hManImage.setImageResource(R.drawable.hangman4);
                break;
            case 5:
                this.hManImage.setImageResource(R.drawable.hangman5);
                break;
            case 6:
                this.hManImage.setImageResource(R.drawable.hangman6);
                break;
            default:
                this.hManImage.setImageResource(R.drawable.hangman0);
                break;
        }

    }

    public String getBoardText() {
        String s = "";
        if (isSolved()) {
            return this.currentWord;
        }
        for (int i =0; i < this.currentWord.length(); i++) {
            if (this.guesses[i]) {
                s+=this.currentWord.charAt(i) + " ";
            } else {
                s+="_";
                if (this.currentWord.length() - 1 != i) {
                    s+=" ";
                }
            }
        }
        return s;
    }
}