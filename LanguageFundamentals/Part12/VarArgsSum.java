class VarArgsSum{
  public static void sum(int... numbers){
    int sum = 0;
    for(int num : numbers){
      sum += num;
    }
    System.out.println("The Total Is : " + sum);
  }

  public static void main(String... args){
    sum();
    sum(10,20);
    sum(10,20,30);
    sum(10,20,30,40);
  }
}
