/*
	Here Object class equals() method compare object reference only.
	That is why dummy and dummy2 having same content are not equal,
	but dummy and dummy3 having same references are equal.
	Whereas in String class equals() method is overriden to compare
	content of objects.
*/

class Dummy{
	int total;
	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return this.total;
	}
}

class EqualsMethodReferenceComparison{
	public static void main(String... s){
		Dummy dummy = new Dummy();
		dummy.setTotal(10);
		Dummy dummy2 = new Dummy();
		dummy2.setTotal(10);
		Dummy dummy3 = dummy;

		System.out.println("Does Object's class equals() compare content?  " + dummy.equals(dummy2));
		System.out.println("Does Object's class equals() compare reference? " + dummy.equals(dummy3));
	}

}