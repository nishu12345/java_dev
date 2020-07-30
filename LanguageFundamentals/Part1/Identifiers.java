/*
	A name in java which is used for identification purposes are known as Identifiers.
	It can be class name, method name, variable name or label name. 
	Rules for defining an identifier:-
		1) Only below mentioned characters are allowed,
			a to z,
			A to Z,
			0 to 9,
			$ , _
			[From java9 we can't use '_' alone as it is a keyword]

		2) Identifiers can't start with numeric value.

		3) Java is a case-sensitive language, so idenfiers number, Number and NUMBER are different.

		4) We can't use reserved keyword as identifiers.

		5)All pre-defined class and interface names are valid identifiers.

	In below program there are 5 identifiers:-
	Identifiers, as its class name,
	main, as its method name,
	String, a predifined class name,
	s, name of the variable,
	x, again name of the variable.
*/
class Identifiers{
	public static void main(String... s){
		int x = 10;
		// int total# = 90; invalid, # not allowed as valid identifiers.
		// int _ = 20; invalid, from java9 '_' is a keyword.
		int total123 = 100;
		// int 123total = 50; invalid, idenfiers can't start with numeric value.
		int $abc = 9;
		// int if = 20; invalid, can't use reserved keywords as identifiers.
		int String = 999; //valid, as String is not a reserved keyword.
		System.out.println(String);
		// int int = 80; invalid as int is a reserved keyword.
		int finalize = 10; //finalize is not a reserved keyword.
	}
}