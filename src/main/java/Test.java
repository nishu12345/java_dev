import java.util.Arrays;

class Test {
    public static void main(String[] args) {
//        int power = calPower(3);
//        System.out.println(power);
        long pow = (long)Math.pow(2, 50);
        int[] A = {5,10,25,0,3};
        int[] temp = A.clone();
        Arrays.sort(temp);
        for(int num : A){
            System.out.println(num + " ");
        }
//        System.out.println(pow);
//        System.out.println(Long.MAX_VALUE);
    }

    private static int calPower(int input) {
        int output = 1;
        for (int i = 1; i < input; ++i)
            output = output * 2;
        return output;
    }
}