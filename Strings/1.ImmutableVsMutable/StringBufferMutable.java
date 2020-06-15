/*
	StringBuffer are mutable in nature i.e we can do modification on it.
	And after doing modification, no new objects are created.
*/
class StringBufferMutable{
	public static void main(String... s){
		StringBuffer sb = new StringBuffer("Durga");
		sb.append("software");
		System.out.println(sb);
	}
}