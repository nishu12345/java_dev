package week7.basic_math_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Two players are playing a game. The rules are as follows:
    Player 1 always moves first, and both players always play optimally.
    Initially there are A piles, where each pile has B number of stones.
    The players move in alternating turns. In each turn, a player can choose a pile of size x and reduce the number of stones to y,
    where 1 <= y < x, and x and y are coprime.
    If the current player is unable to make a move, they lose the game.
    Determine the winner of the game.
    Input->
        numberOfPiles = 2
        numberOfCoins = 2
    Output->
        2
    Explanation->
         The only possible scenario is player 1 chooses any one pile and reduce it to 1.
         Then Player 2 reduces the other pile to 1 and wins.

*/
public class ThePrimeGame {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThePrimeGame.class);

    public static void main(String[] args) {
        int theWinner = getTheWinner(2, 2);
        LOGGER.info("The winner in given input is {}", theWinner);
    }

    public static int getTheWinner(int numberOfPiles, int numberOfCoins) {
        if (numberOfCoins == 1 || numberOfPiles % 2 == 0)
            return 2;
        return 1;
    }
}
