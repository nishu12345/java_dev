package week4.introduction_to_hashing_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Tom and Harry are given N numbers, with which they play a game as a team.
    Initially, Tom chooses a particular number P from the N numbers, and he takes away all the numbers that are equal to P.
    Next, Harry chooses a different number Q, different from what Tom chose, and takes away all the numbers equal to Q from
    the remaining N numbers. They win the game if they can take all the numbers by doing the above operation once and if each
    of them has the same amount of numbers towards the end.
    If they win, return the string "WIN", else return "LOSE".

    Input->
        [1,1,2,2,2]
    Output->
        LOSE
*/
public class PerfectCards {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(1);
        input.add(2);
        input.add(2);
        input.add(2);
        String gameResult = playGame(input);
        System.out.println("What is the game result > " + gameResult);

    }

    public static String playGame(ArrayList<Integer> input) {
        Map<Integer, Integer> hashed = new HashMap<>();
        for (Integer num : input) {
            if (hashed.containsKey(num))
                hashed.put(num, hashed.get(num) + 1);
            else hashed.put(num, 1);
        }
        if (hashed.size() == 2) {
            ArrayList<Integer> values = new ArrayList<>(hashed.values());
            if (values.get(0) == values.get(1))
                return "WIN";
        }
        return "LOSE";
    }
}
