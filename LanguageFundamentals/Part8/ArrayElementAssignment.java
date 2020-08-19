class ArrayElementAssignment{
public static void main(String... s){
// primitive types arrays can have any types which is implicityly promoted to declared type.
int[] x = new int[5];
short s1 = 10;
x[0] = s1;
x[1] = 10;
byte b = 5;
x[2] = b;

//Object type arrays can either have declared type or its child class objects
Object[] obj = new Object[5];
obj[0] = new Object();
obj[1] = new String("Nishant");

//Abstract class types arrays can hold its child classes objects.
Number[] num = new Number[5];
num[0] = new Integer(10);

//Intergace type array can hold its implementation classes objects.
Runnable[] run = new Runnable[5];
run[0] = new Thread();

}
}
