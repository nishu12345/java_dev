interface Interf{
	void m1();
}

class InterfImpl implements Interf{
	public void m1(){
		System.out.println("m1 Implementation");
	}
}

public class TestWithoutParameters{
	public static void main(String... s){
		Interf interf = new InterfImpl();
		interf.m1();	

		Interf intref2 = () -> System.out.println("Function 			Interface Implentation");
		intref2.m1(); 
	}
}
