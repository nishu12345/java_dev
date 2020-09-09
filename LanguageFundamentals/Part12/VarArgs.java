class VarArgs{
  public static void main(String[] args) {
    m1();
    m1(10);
    m1(10,20);
  }
  public static void m1(int... x){
    System.out.println("Variable Value > " + x);
    System.out.println("Var-Arg Method" + x.length);

  }
}
