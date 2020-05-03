interface Interf{
	void add(int a,int b);
	default void m1(){
		System.out.println("Default Method");	
	}
	
	static void m2(){
		System.out.println("Static Method");
	}
}

class InterfImpl implements Interf{
	public void add(int a, int b){
		System.out.println("Sum : " + (a+b));
	}
}

interface Interf2{
	int square(int n);
}

class Interf2Impl implements Interf2{
	public int square(int n){
	return n*n;	
	}
}


class TestWithParameters{
	public static void main(String... s){
		Interf i = new InterfImpl();
		i.add(10,20);	

		Interf i1 = (a,b) -> System.out.println("Sum By Lambda " + 			(a+b));
		i1.add(100,200);
		i1.m1();
		Interf.m2();


		Interf2 i2 = new Interf2Impl();
		System.out.println("Square of 5 =" + i2.square(5));

		Interf2 i3 = n -> {
					System.out.println("hello");
					 return n*n;
				};
		System.out.println("Square of 6 = " + i3.square(6));
	}

}
