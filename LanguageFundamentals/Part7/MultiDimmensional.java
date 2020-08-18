class MultiDimmensional{
  public static void main(String... s){
// 2D array creation
    int[][] x = new int[2][];
    x[0] = new int[3];
    x[1] = new int[2];

// 3D array creation
    int[][][] y = new int[2][][];

    y[0] = new int[2][];
    y[0][0] = new int[1];
    y[0][1] = new int[3];

    y[1] = new int[2][2];

    int[] x1 = new int[2];
    System.out.println(x1);     //[I@3a8b
    System.out.println(x1[0]);  // 0

    int[][] y1 = new int[2][3];
    System.out.println(y1);       //[[I@a8b5
    System.out.println(y1[0]);    //[I@23ae
    System.out.println(y1[0][0]); //0

    int[][] y3 = new int[2][];
    System.out.println(y3);       //[[I@b4ce
    System.out.println(y3[0]);    //null
    System.out.println(y3[0][0]); //at runtime, null pointer exception
  }
}
