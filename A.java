@FunctionalInterface
interface A{
	void m1();
}

//@FunctionalInterface
interface B extends A{
	void m1();
}

@FunctionalInterface 
interface C{
()->System.out.println("Hello");
}
