/*
	Class A and Class B have two synchronized method d1() and d2() respectively.
	They also have last() method which is synchronized.
	When d1() method is called from ThreadA, it needs lock of object A as d1() is
	synchronized. Also when d2() method is called from Main Thread, it needs lock
	of object B as it is synchronized. So both Main thread and ThreadA are holding
	lock of object A and object B respectively.

	Now class A is waiting for lock of object B, to call b.last() from d1() method.
	And class B is waiting for lock of object A, to call a.last() from d2() method.
	So both the threads will wait for each other lock infinitely and this is known
	as deadlock situation.
*/
class A{
	synchronized void d1(B b){
		System.out.println("Executing Class A's d1() method");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println("Class A is interrupted");
		}
		System.out.println("Calling Class B's last() method");
		b.last();
	}

	synchronized void last(){
		System.out.println("Executing Class A's last() method");
	}
}

class B{
	synchronized void d2(A a){
		System.out.println("Executing Class B's d2() method");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println("Class B is interrupted");
		}
		System.out.println("Calling Class A's last() method");
		a.last();
	}

	synchronized void last(){
		System.out.println("Executing Class B's last method");
	}
}

class ThreadA implements Runnable{
	A a;
	B b;
	ThreadA(A a, B b){
		this.a = a;
		this.b = b;
	}

	public void run(){
		a.d1(b);
	}
}

class DeadLockExample{

	public static void main(String... s){
		A a = new A();
		B b = new B();

		ThreadA threadA = new ThreadA(a,b);
		Thread t1 = new Thread(threadA);
		t1.start();

		b.d2(a);

	}

}