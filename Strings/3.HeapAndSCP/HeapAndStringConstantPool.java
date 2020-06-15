/*
	String objects are created in Heap Area and String Constant Pool.
	When new keyword is used to create the string, two objects are 
	created. One in heap area and another in string constant pool.

	But when string is created with equal operator, only one object is 
	created in string constant pool. Jvm first checks whether the new 
	content of string is present in scp or not. If present, the same
	object is used, else new object is created.
*/

class HeapAndStringConstantPool{
	public static void main(String... s){
		//two objects are created, one in heap area and another in scp area.
		//s1 is pointing to object in heap area.
		String s1 = new String("Durga");

		//only once object is created in scp area. And before creating the object,
		//jvm checks whether this content is present in scp area or not. If present,
		//that same object is reused else, new object is created.
		String s2 = "Durga";

		objectCountExample2.run();
		objectCountExample3.run();
		
	}


	private static Runnable objectCountExample1 = () -> {
		/*
			In total 3 objects will be created. Two in heap area with content "Durga" and one in
			string constant pool area "Durga".
		*/

		String s1 = new String("Durga");// one object in heap and one copy in scp.
		String s2 = new String("Durga");//one object in heap and as scp already has one copy from above line, it will be reused.
		String s3 = "Durga";//Already scp has object with content as Durga, it will be reused and s3 points to that object.
		String s4 = "Durga";//Already scp has object with content as Durga, it will be reused and s4 points to that object.
	};

	private static Runnable objectCountExample2 = () -> {

		/*
			In total 6 object will be created.
				HeapArea		|	String Constant Pool
								|
				Durga  	    	|   Durga
				DurgaSoftware	|	Software
				DurgaSolutions	|	Solutions
		*/
		String s1 = new String("Durga");//One object in heap and one copy in scp.
		/*
			As "Software" is a string literal, one object will be created in scp, and at runtime when concat() method
			will be executed new object will be created in Heap area as "Durga Software". But as no variable is pointing
			to this newly created objet it is eligible for garbage collection.
		*/
		s1.concat("Software");

		/*
			Here "Solutions" is a string literal so a new object will be created in string constant pool area. And
			at runtime when concat() method is executed on s1, new object will be created as "DurgaSolutions" in heap
			area. And s1 will be pointing to this newly created object.
		*/
		s1 = s1.concat("Solutions");

		System.out.println(s1);
	};

	private static Runnable objectCountExample3 = () -> {
		/*
			Here total 8 objects will be created.

				Heap          		|    String Constant Pool
							  		|
		s1->	Spring        		|	   	Spring
				DurgaFall	  		|	   	Fall
		s2->	SpringWinter 	 	|    	Winter
				SpringWinterSummer	|    	Summer
		*/
		String s1 = new String("Spring");
		s1.concat("Fall");
		String s2 = s1.concat("Winter");
		s2.concat("Summer");
		System.out.println("Value of S1 > " + s1);
		System.out.println("Value of S2 > " + s2);
	};
}