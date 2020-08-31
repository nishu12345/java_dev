class LocalVariables{
  public static void main(String... args){
/*
We can't use local variables without intitializing it.
        int x;
        System.out.println(x);
*/

/*We don't need to initialize local variables if we are not using it.*/
        int y;
        System.out.println("Hello");

/*It is not recommended to intialize local variable in logical block.
Like in below example if we forget to write else part, compile time
error will arrise. So better to intialize local variable at time of
declaration, atleast with default values.
*/
        int z;
        if(args.length > 0){
          z = 10;
        }else{
          z = 20;
        }
        System.out.println(z);

  }
}
