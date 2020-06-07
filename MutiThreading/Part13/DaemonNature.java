/*
	Main Thread is non-daemon thread by default.
	We can't daemon nature of main thread as it is already started by jvm.
	Child thread inherit the daemon nature from its parent thread where it
	is created. Also we can change the daemon nature of the thread before 
	it has been started. If we change the daemon nature of thread after it
	has been started we will get runtime exception as IllegalThreadStateException. 
	Thread t1 has been created inside main thread so it will be a non-daemon
	thread by default. But we can make thread t1 as daemon thread by using
	setDaemon(true).
*/

class DaemonNature{
	public static void main(String... s){
		// Runnable r = () -> System.out.println("Child Thread");
		System.out.println(Thread.currentThread().isDaemon());
		// Thread.currentThread().setDaemon(true);
		Thread t1 = new Thread(() -> System.out.println("Child Thread"));
		System.out.println("Is Child Thread Daemon " + t1.isDaemon());
		t1.setDaemon(true);
		System.out.println("Is Child Thread Daemon " + t1.isDaemon());
		t1.start();
	}
}