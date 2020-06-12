/*
	Here single thread local object to store separate value for each thread.
	Where as to achieve this using local variable we would have needed as 
	multiple local variable.
*/

class Customer implements Runnable{
	static Integer custId = 0;
	static ThreadLocal tl = new ThreadLocal(){
		public Object initialValue(){
			return ++custId;
		}
	};

	public void run(){
		System.out.println(Thread.currentThread().getName() + " executing with  Customer id: " + tl.get());
	}
}
class ThreadLocalUse{
	public static void main(String... s){
		Customer customer1 = new Customer();
		Thread t1 = new Thread(customer1,"Customer Thread - 1");

		Customer customer2 = new Customer();
		Thread t2 = new Thread(customer2, "Customer Thread - 2");

		Customer customer3 = new Customer();
		Thread t3 = new Thread(customer3, "Customer Thread - 3");

		Customer customer4 = new Customer();
		Thread t4 = new Thread(customer4, "Customer Thread - 4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}