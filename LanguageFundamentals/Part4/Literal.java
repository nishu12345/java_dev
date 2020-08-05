class Literal{
	public static void main(String[] args) {
		int x = 10;		//decimal literal, base 10.
		int x1 = 010;	//octal literal, base 8.
		int x2 = 0X10A;	//hexadecimal literal, base 16.
		int x3 = 0x20b;	//hexadecimal literal, base 16.

		System.out.println(x + "..." + x1 + "..." +  x2 + "..." + x3);

			// int a1 = 0786; compile time error, integer number too large.
			int a2 = 0XBeef; 
			int a3 = 0xface;
			System.out.println(a2 +"..." + a3);

			
			// float f = 123.465; compile time error, every floating point literal is of double type by default.
			float f1 = 123.465f;

			double d = 123.456d;
			double d1 = 123.456D;

			System.out.println(f1 + "..." + d + "..." + d1);

			//In floating point literal, there is no representation of octal and hexadecimal.
			double d2 = 0123.456; //Instead the literal starts with 0, it is treated as decimal literal.
			// double d3 = 0X123.456; compile time error, malformed floating point literal.
			System.out.println(d2);

			// Integral literal can be directly assigned to floating point variable.

			// double d4 = 0786; compile time error, integer number too large. As 0786 is integral literal and is treated as octal.
			double d4 = 0786.0; // valid, as this is floating point literal and even if its start with 0 will be treated as decimal.

			double d5 = 0XFace; // valid, as this is integral(hexadecimal) literal.
			// double d6 = 0XFace.0; compile time error, malformed floating point literal. As hexadecimal is not allowed in floating point literal.

			double d6 = 0777; // valid, as this is integral(octal) literal.

	}
}