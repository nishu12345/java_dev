/*
	Class A and Class B both have two synchronized method as d1() and d2() respectively.
	Also, last() method is present in both the classes which is synchronized too.
	Here main thread is calling m1() method of class MyThread. Method m1() is starting
	a new thread by executing its run() method. The new thread is responsible to execute
	class A's d1() method by passing object of B as argument. Further m1() method is 
	executing class B's d2() method by passing object of A as argument.

	Now main thread is holding the lock of object B while executing class B's d2() method.
	And MyThread is holding the lock of object A while executing class A's d1() method.
	Main thread is waiting for lock of object A to execute a.last() which is currently 
	holded by MyThread, and MyThread is waiting for lock of object B to execute b.last()
	which is currently held by Main Thread. So both the threads will wait for objects lock
	which are held by each other infinitely and this is known as deadlock situation.
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
		System.out.println("Executing Class B's last() method");
	}
}

class MyThread implements Runnable{
	A a = new A();
	B b = new B();

	void m1(){
		Thread t1 = new Thread(this);
		t1.start();
		b.d2(a);
	}

	public void run(){
		a.d1(b);
	}
}
class DeadLockSituation{
	public static void main(String... s){
		MyThread myThread = new MyThread();
		myThread.m1();
	}

}