/*
	Strings are immutable in nature i.e once created they can't be modified.
	If any modification occur on it, a new object is created.
	Here after doing concat() on s1, a new object is created with that change,
	and if we want to use that it need to be referenced to a variable.
*/
class StringImmutable{
	public static void main(String... s){
		String s1 = new String("Durga");
		s1.concat("software");
		System.out.println(s1);
	}
}