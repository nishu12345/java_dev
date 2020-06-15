
/*
	Here double equals operator is meant for reference comparison.
	So sb1 == sb2 will give false.
	Also equals() method is not overriden in StringBuffer class, so 
	equals method is called of Object class. And object class equals()
	method also does referencec comparison. Hence, sb1.equals(sb2)
	will give false
*/
class DoubleEqualAndEqualOnStringBuffer{
	public static void main(String... s){
		StringBuffer sb1 = new StringBuffer("Durga");
		StringBuffer sb2 = new StringBuffer("Durga");
		System.out.println("Is StringBuffer sb1 == StringBuffer sb2 ? " + (sb1 == sb2));
		System.out.println("Is StringBuffer sb1 equals() StringBuffer sb2 ? " + sb1.equals(sb2));
	}
}