class AnonymousArray{
  public static void main(String[] args) {
    sum(new int[]{10,20,30});
    int[][] x = new int[][]{40,50,60};
  }

  public static void sum(int[] numbers){
    int total = 0;
    for(int num : numbers){
      total+=num;
    }
    System.out.println("Sum = " + total);
  }
}
