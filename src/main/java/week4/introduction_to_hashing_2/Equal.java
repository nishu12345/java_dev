package week4.introduction_to_hashing_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;

/*
    Given an array A of N integers, find the index of values that satisfy P + Q = R + S,where
    P,Q,R & S are integers values in the array.If no solution exists return empty array.
    NOTE:
        1) Return the indices `A1 B1 C1 D1`, so that
            A[A1] + A[B1] = A[C1] + A[D1]
            A1 < B1, C1 < D1
            A1 < C1, B1 != D1, B1 != C1

        2) If there are more than one solutions,then return the tuple of values which are lexicographical smallest.
           Assume we have two solutions
                S1 : A1 B1 C1 D1 ( these are values of indices in the array )
                S2 : A2 B2 C2 D2
           S1 is lexicographically smaller than S2 if:
                A1 < A2 OR
                A1 = A2 AND B1 < B2 OR
                A1 = A2 AND B1 = B2 AND C1 < C2 OR
                A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
    Input-> [3, 4, 7, 1, 2, 9, 8]
    Output-> [0, 2, 3, 5]
    Explanation-> A[0] + A[2] = A[3] + A[5]

 */
public class Equal {
    public static void main(String[] args) {
        int[] indexesOfEqualSumPairs = indexesOfEqualSumPairs(new int[]{3, 4, 7, 1, 2, 9, 8});
//        int[] indexesOfEqualSumPairs = indexesOfEqualSumPairs(new int[]{1, 1, 1, 1, 1});
        for (int num : indexesOfEqualSumPairs) {
            System.out.print(num + " ");
        }
    }

    public static int[] indexesOfEqualSumPairs(int[] input) {
        int[] output = new int[0];
        Map<Integer, ArrayList<Integer>> hashed = new HashMap<>();
        for (int i = 0; i < input.length; ++i) {
            for (int j = i + 1; j < input.length; ++j) {
                int sum = input[i] + input[j];
                if (hashed.containsKey(sum)) {
                    ArrayList<Integer> temp = hashed.get(sum);
                    int first = temp.get(0);
                    int second = temp.get(1);
                    if ((first != i && first != j) && (second != i && second != j) && temp.size() != 4) {
                        temp.add(i);
                        temp.add(j);
                    }
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    hashed.put(sum, temp);
                }
            }
        }
        ArrayList<ArrayList<Integer>> listOfValues = new ArrayList<>(hashed.values());
        int a = MAX_VALUE, b = MAX_VALUE, c = MAX_VALUE, d = MAX_VALUE;

        int flag = 0;
        for (ArrayList<Integer> indexesList : listOfValues) {
            if (indexesList.size() == 4) {
                flag = 1;
                int firstIndex = indexesList.get(0);
                int secondIndex = indexesList.get(1);
                int thirdIndex = indexesList.get(2);
                int fourthIndex = indexesList.get(3);
                if ((firstIndex < a) || (firstIndex == a && secondIndex < b) || (firstIndex == a && secondIndex == b && thirdIndex < c) || (firstIndex == a && secondIndex == b && thirdIndex == c && fourthIndex < d)) {
                    a = firstIndex;
                    b = secondIndex;
                    c = thirdIndex;
                    d = fourthIndex;
                }
            }
        }
        if (flag == 1) {
            output = new int[4];
            output[0] = a;
            output[1] = b;
            output[2] = c;
            output[3] = d;
        }
        return output;
    }


}
