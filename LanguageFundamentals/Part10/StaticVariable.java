class StaticVariable{
  static int x = 10;
  static int i;
  static double d;
  static String s;

  public static void main(String[] args) {
    StaticVariable staticVariable = new StaticVariable();
    System.out.println(staticVariable.x);// valid but not recommended to access static variables with object references.
    System.out.prinltn(StaticVariable.x);
    System.out.println(x);

// Default values are provided by jvm for static variables.
    System.out.println(i);  //0
    System.out.println(d);  //0.0
    System.out.println(s);  //null

  }

  public void m1(){
    // static variables can be accessed directly from non-static context.
    System.out.println(x);
  }
}
