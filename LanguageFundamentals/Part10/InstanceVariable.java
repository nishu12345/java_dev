class InstanceVariable{
  int x = 10;
  int i;
  double d;
  boolean b;
  String s;
  public static void main(String[] args) {
    // System.out.println(x); compile time error: non-static variable cannot be referenced
    //                                             from a static context.
    InstanceVariable instanceVariable = new InstanceVariable();
    System.out.println(instanceVariable.x);
    // It's not mandatory to initialize instance variable, there default value is used.
    System.out.println(instanceVariable.i);
    System.out.println(instanceVariable.d);
    System.out.println(instanceVariable.b);
    System.out.println(instanceVariable.s);
  }

  public void m1(){
    // instance varibale can be accessed directly from instance methods.
    System.out.println(x);
  }
}
