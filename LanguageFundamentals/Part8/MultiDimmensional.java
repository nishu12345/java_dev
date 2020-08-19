class MultiDimmensional{
  public static void main(String[] args) {
    int[] x = {10,20,30};

    int[][] y1 = new int[2][];
    y1[0] = new int[2];
    y1[0][0] = 10;
    y1[0][1] = 20;

    y1[1] = new int[3];
    y1[1][0] = 10;
    y1[1][1] = 20;
    y1[1][2] = 30;


    //single line declaration, creation and initialization of y1 array.
    int[][] y2 = {{10,20},{10,20,30}};

    int[][][] z1 = {{{10,20,30},{40,50,60}},{{70,80},{90,100,110}}};
    System.out.println(z1[0][1][2]); //60
    System.out.println(z1[1][0][1]); //80
    // System.out.println(z1[2][0][0]); //ArrayIndexOutOfBoundException
    // System.out.println(z1[1][2][0]); //ArrayIndexOutOfBoundException
    System.out.println(z1[1][1][1]); //100
    // System.out.println(z1[2][1][0]); //ArrayIndexOutOfBoundException

    int[][][] z2 = new int[2][2][];
    z2[0][0] = new int[3];
    z2[0][0][0] = 10;
    z2[0][0][1] = 20;
    z2[0][0][2] = 30;

    z2[0][1] = new int[3];
    z2[0][1][0] = 40;
    z2[0][1][1] = 50;
    z2[0][1][2] = 60;

    z2[1][0] = new int[2];
    z2[1][0][0] = 70;
    z2[1][0][1] = 80;

    z2[1][1] = new int[3];
    z2[1][1][0] = 90;
    z2[1][1][1] = 100;
    z2[1][1][2] = 110;

    System.out.println(z2[0][1][2]); //60
    System.out.println(z2[1][0][1]); //80
    // System.out.println(z2[2][0][0]); //ArrayIndexOutOfBoundException
    // System.out.println(z2[1][2][0]); //ArrayIndexOutOfBoundException
    System.out.println(z2[1][1][1]); //100
    // System.out.println(z2[2][1][0]); //ArrayIndexOutOfBoundException

    // int[] x;
    // x = {20,30}; compile time error, illegal start of expression

    int[] a = new int[6];
    System.out.println(a.length);

    int[][] a1 = new int[6][3];
    System.out.println(a1.length);

    int[] a2 = new int[]{10,20};

    System.out.println(a2[0]);

  }
}
