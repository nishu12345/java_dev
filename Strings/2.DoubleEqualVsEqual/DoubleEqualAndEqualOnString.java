/*
	Double equal operator is doing reference comparison so s1 == s2 will be false.
	But equals() method in String class is overriden from Object class to do content
	comparison. So s1.equals(s2) will be true.
*/

class DoubleEqualAndEqualOnString{
	public static void main(String... s){
		String s1 = new String("Durga");
		String s2 = new String("Durga");
		System.out.println("Is String s1 == String s2 > " + (s1 == s2));
		System.out.println("Is String s1 equals() String s2 > " + s1.equals(s2));
	}
}