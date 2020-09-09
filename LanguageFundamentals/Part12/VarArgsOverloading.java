class VarArgsOverloading{
  public static void m1(int... x){
    System.out.println("Var-Args Method");
  }
  public static void m1(int a){
    System.out.println("General Method");
  }
  public static void main(String[] args) {
    m1(1);
  }
}
