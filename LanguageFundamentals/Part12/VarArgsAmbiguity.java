class VarArgsAmbiguity{
	public static void m1(int... x){
		System.out.println("General Method");
	}

	public static void m1(int a, int... b){
		System.out.println("Method With Var Args Argument");
	}
	public static void main(String[] args) {
		m1(10);
		m2();
	}

	public static void m2(boolean... b){

	}

	public static void m2(int... a){

	}
}