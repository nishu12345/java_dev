class StringObjectAllocation{
	public static void main(String... s){

		/*
			Heap 			       	|              	String Constant Pool
									|				
	s1->	You Cannot Change Me	|				You Cannot Change Me 	<-s3,s4,s5,s9
	s2->	You Cannot Change Me	|				
									|				You Cannot              <-s6,s8
	s7->	You Cannot Change Me	|				Change Me
									|
		*/
		String s1 = new String("You Cannot Change Me");
		String s2 = new String("You Cannot Change Me");
		System.out.println("Is s1 == s2? " + (s1 == s2));//false

		String s3 = "You Cannot Change Me";
		System.out.println("Is s1 == s3? " + (s1 == s3));//false

		String s4 = "You Cannot Change Me";
		System.out.println("Is s3 == s4? " + (s3 == s4));//true

		/*Here concatenation will happen at compile time only, and the result will be treated as single literal*/
		String s5 = "You Cannot " + "Change Me";
		System.out.println("IS s4 == s5? " + (s4 == s5));//true

		String s6 = "You Cannot ";
		/*Here one side is variable and other is constant, so this operation will be performed at runtime.
			And hence a new object will be created in heap area, s7 will point to that new object*/
		String s7 = s6 + "Change Me";
		System.out.println("Is s4 == s7? " + (s4==s7));//false


		final String s8 = "You Cannot ";
		/*Here s8 is a final variable, so is treated as constant. And every final variable value/constants is
			is replaced by its value at compile time only. So s9 will hold a single string literal*/
		String s9 = s8 + "Change Me";
		System.out.println("Is s4 == s9? " + (s4==s9));//true
	}

}