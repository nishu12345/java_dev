/*
	Thread priority is defined in the range from 1 to 10,
	where 1 is MIN_PRIORITY and 10 is MAX_PRIORITY.
	If priority is defined outside of the mentioned range, 
	IllegalArgumentException is thrown at runtime.
	Only main thread priority is 5 by default i.e NORM_PRIORITY.
	Rest all the thread inherit its priority from parent thread,
	i.e the thread where they are instantiated.
*/

class MyThread extends Thread{
	public void run(){
		System.out.println("Child Thread");
	}
}

class ThreadPriority{
	public static void main(String... s){
		System.out.println("Main Thread Priority > " +Thread.currentThread().getPriority());
		// Thread.currentThread().setPriority(17);
		Thread.currentThread().setPriority(9);
		MyThread t = new MyThread();
		System.out.println("Child Thread Priority > " + t.getPriority());
		Thread.currentThread().setPriority(5);
		System.out.println("Child Thread Priority > " + t.getPriority());
	}
}