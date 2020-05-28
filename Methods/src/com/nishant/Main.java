package com.nishant;

public class Main {

    public static void main(String[] args) {

//        calculateScore(true, 800, 5, 100);
//        calculateScore(true, 10000, 8, 200);


        displayHighScorePosition("Larry ", calculateHighScorePosition(1500));
        displayHighScorePosition("Tim", calculateHighScorePosition(900));
        displayHighScorePosition("Steve", calculateHighScorePosition(400));
        displayHighScorePosition("Bill", calculateHighScorePosition(50));


    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }
        return -1;
    }

    public static int calculateHighScorePosition(int score) {
    	int position = 4;
        if (score >= 1000) {
            position = 1;
        } else if (score >= 500) {
            position = 2;
        } else if (score >= 100) {
            position = 3;
        }

        return position;
    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " managed to get into position " + position + " on the high score table");
    }
}
