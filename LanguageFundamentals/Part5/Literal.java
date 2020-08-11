class Literal{
	public static void main(String[] args) {
		char ch = 'a';
	/*	char ch1 = a;	compile time error, cannot find symbol. As a is of no valid data type,
		 				compiler will treat it as a variable.	*/
		 

	/*	char ch2 = "a";	compile time error*, incompatible types. String cannot be converted
						to char*/

	/*	char ch3 = 'ab';compile time error*/

	char ch4 = 97; 		// valid as decimal integral literal can be assigned to char.
	System.out.println(ch4);

	char ch5 = 0xFace; 	// valid as hexadecimal integral literal can be assigned to char.
	System.out.println(ch5);

	char ch6 = 0777; 	//valid as octal integral literal can be assigned to char.
	System.out.println(ch6);

	// char ch7 = 65536; 	compile time error, possible loss of precision.

	char ch8 = '\u0061'; //unicode representation of a.
	System.out.println(ch8);

	char ch9 = '\uabcd';
	System.out.println(ch9);

	char ch10 = '\n'; //escape character is valid char literal.

	System.out.println("This is \' character");

	String s = "\uFace\uabcd"; //String literals
	System.out.println(s);

	int x = 0b1111;	//binary literals
	System.out.println(x);

	double x1 = 1_23_456.7_8_9;
	System.out.println(x1);

	int x4 = ch8; //char value can be assigned to int
	System.out.println(ch8);


	float f = 10l;// 8 byte long  value can be assigned to 4 byte float value
	System.out.println(f);

	
	}
}