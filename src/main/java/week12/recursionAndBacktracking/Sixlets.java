package week12.recursionAndBacktracking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
  Given a array of integers A of size N and an integer B.
  Return number of non-empty subsequences of A of size B having sum <= 1000.
  Input -> A = [1,2,8]
           B = 2
  Output -> 3
  Explanation -> {1, 2}, {1, 8}, {2, 8}
* * */
public class Sixlets {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sixlets.class);

    public static void main(String[] args) {
        int[] A = {1,2,8};
        int B = 2;
        int answer = totalSixletsCount(0,0,0,A,B);
        LOGGER.info("Total No of Possible Sixlets for given input A of maximum size B is {}",answer);

    }

    public static int totalSixletsCount(int index, int sum, int count, int[] input, int B){
        if(count == B)
            return 1;
        int ans = 0;
        for(int i = index; i < input.length; ++i){
            if(sum + input[i]> 1000)
                continue;
            ans+=totalSixletsCount(i+1, sum+input[i], count+1, input, B);
        }
        return ans;
    }

}
