class Arrays{
	public static void main(String[] args) {
		int[] x; //This is recommended as name is clearly separated from type.
		int []y;
		int z[];

		int[][] x1;
		int [][]y1;
		int z1[][];
		int[] []x2;
		int[] y2[];
		int[] []z2[];

		int[][] a;
		int[] a1,b1; 			// a1 -> 1D, b1 -> 1D
		int[] a2[],b2; 			// a2 -> 2D, b2 -> 1D
		int[] a3[],b3[]; 		// a3 -> 2D, b3 -> 2D
		int[] []a4,b4; 			// a4 -> 2D, b4 -> 2D
		int[] a5[],b5[]; 		// a5-> 2D, b5 -> 2D
		// int[] []a,[]b; 		compile time error.
	
		int[] b = new int[3];
		System.out.println(b.getClass().getName());

		int[][] c = new int[3][3];
		System.out.println(c.getClass().getName());

		int[][][][][][] d = new int[2][2][2][2][2][2];
		System.out.println(d.getClass().getName());

		// int[]  e = new int[-3]; Runtime exception as NegativeArraySizeException

		int[] f = new int['a'];
		byte g1 = 10;
		int[] g = new int[g1];

		int[] h = new int[2147483647];

	}
}