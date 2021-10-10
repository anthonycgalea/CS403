package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView txtGuessHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //store elements of view globally to make things easier
        this.hManImage = (ImageView) findViewById(R.id.hManImage);
        this.txtBoard = (TextView) findViewById(R.id.txtBoard);
        this.txtGuess = (TextView) findViewById(R.id.txtGuessLetter);
        this.txtGuessHistory = (TextView) findViewById(R.id.txtGuesses);
        loadAssets();
        startNewGame();
    }

    public void loadAssets() {
        InputStream is = getResources().openRawResource(R.raw.wordlist10000); //pull word list
        Scanner sc = new Scanner(is); //for reading words
        wordList = new ArrayList<>(); //intialize arrayList
        while(sc.hasNext()) { //read full file
            wordList.add(sc.nextLine());
        }
    }

    public void startNewGame() {
        Random rand = new Random();
        do {
            int wordNum = rand.nextInt(wordList.size() - 1); //get random word
            this.currentWord = this.wordList.get(wordNum);
        } while(!(this.currentWord.length() >=3 && this.currentWord.length() <= 6)); //check if valid word
        this.guesses=new boolean[this.currentWord.length()]; //create boolean array for checking if letters are valid
        for (int i =0; i < this.guesses.length; i++) { //fill with falses
            this.guesses[i]=false;
        }
        this.incorrectGuesses = 0; //reset guesses
        this.guessHistory = ""; //reset guess letters
        this.txtGuessHistory.setTextColor(Color.BLACK); //in case text color got changed
        this.txtGuess.setText(""); //clear entry box
        updateBoard(); //run board generator
    }

    public void newGame(View view) { //lets me call the new game with the button
        startNewGame();
    }

    public boolean isSolved() {
        for (int i = 0; i < this.guesses.length; i++) { //check each array spot to see if all are true
            if (this.guesses[i] == false) {
                return false;
            }
        }
        return true;
    }

    public void updateBoard() {
        this.txtBoard.setText(getBoardText()); //get the spaced letters with underscores
        sethManImage(); //update hangman image
        renderGuessHistory(); //update guess history text
    }

    public void sethManImage() { //switch statement to get the correct image for the hangman
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

    public void renderGuessHistory() {
        String msg = "";
        if (isSolved()) { //check if won
            msg = "Yay! You won with " + (this.maxGuesses-this.incorrectGuesses) + " guesses left. Play again?";
            this.txtGuessHistory.setTextColor(Color.GREEN);
        } else if (this.incorrectGuesses==this.maxGuesses) { //check if lost
            msg = "You lost. The correct answer was " + this.currentWord;
            this.txtGuessHistory.setTextColor(Color.RED);
        } else { //if still playing
            msg = "Guess History: " + this.guessHistory;
        }
        this.txtGuessHistory.setText(msg);
    }

    public void guessLetter(View view) {
        if (isSolved() || this.incorrectGuesses==this.maxGuesses) { //if won or lost
            Toast toast = Toast.makeText(this, "This game has ended. Please start a new game.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        String guess = ""+txtGuess.getText();
        guess=guess.trim().toLowerCase();
        if (guess.length()==0) { //if empty
            Toast toast = Toast.makeText(this, "Please enter a letter.", Toast.LENGTH_SHORT);
            txtGuess.setText("");
            toast.show();
            return;
        } else if (this.guessHistory.contains(guess)) { //if already guessed
            Toast toast = Toast.makeText(this, "Please enter an letter that has not been guessed.", Toast.LENGTH_SHORT);
            txtGuess.setText("");
            toast.show();
            return;
        } else if (guess.charAt(0) > 'z' || guess.charAt(0) < 'a') { //if not a letter
            Toast toast = Toast.makeText(this, "Please enter an alphabetical letter.", Toast.LENGTH_SHORT);
            txtGuess.setText("");
            toast.show();
            return;
        }
        guessHistory+=guess;
        if (this.currentWord.contains(guess)) { //if letter in word
            for (int i = 0; i < guesses.length; i++) {
                if (currentWord.charAt(i) == guess.charAt(0)) {
                    guesses[i] = true;
                }
            }
        } else { //its wrong
            this.incorrectGuesses++;
        }
        txtGuess.setText("");
        updateBoard();
    }

    public String getBoardText() { //render text for spaces and underscores
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