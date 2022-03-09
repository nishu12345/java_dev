class Test {

    public static void main(String[] args) {
        int a = 1;
        a = a<<32;
        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(a<<31));
//        System.out.println(a<<31);
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(a);
        int temp = 21;
        String s = Integer.toBinaryString(temp);
        int tempNew = Integer.parseInt(s);
        System.out.println(tempNew);
    }
}













































/*int findMaxSumContagiousArr(int arr[]) {
 *//*
 {2, -1, -3, -3, 4, 2, 3, 4, -5};
{-73, -1, -31, -1, -2}
int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
*//*
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = i == 0 ? arr[i] : currSum + arr[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }*/
