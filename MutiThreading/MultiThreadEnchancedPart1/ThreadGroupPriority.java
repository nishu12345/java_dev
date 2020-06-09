/*
	By default max priority of a thread group is 10 i.e threads inside that group
	can have atmost 10 as maximum priority. But after setting max priority of a
	thread group all the newly created thread will have the above mentioned priority.

	Here thread group g1 default max priority is 10, so thread t1 having priority as 5
	is allowed. Also thread t2 having priority as 2 is allowed in thread groupd g1.
	But after setting max priority of g1 as 3, all the newly created thread i.e thread t3
	will have its priority as 3 only. But this will not change the priorities of previous 
	threads existing in the same group.
*/

class MyThread implements Runnable{
	public void run(){
		System.out.println("Child Thread ");
	}
}

class ThreadGroupPriority{
	public static void main(String... s){
		ThreadGroup g1 = new ThreadGroup("First Thread Group");
		System.out.println("First Thread Group Max Priority > " + g1.getMaxPriority());
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(g1,myThread);
		Thread t2 = new Thread(g1,myThread);
		t2.setPriority(2);
		g1.setMaxPriority(3);
		Thread t3 = new Thread(g1,myThread);

		System.out.println("Thread t1 priority > " + t1.getPriority());
		System.out.println("Thread t2 priority > " + t2.getPriority());
		System.out.println("Thread t3 priority > " + t3.getPriority());
		t1.start();
		t2.start();
		t3.start();

		System.out.println(g1.activeCount());
		System.out.println(g1.activeGroupCount());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().activeCount());
		System.out.println(Thread.currentThread().getThreadGroup().activeGroupCount());

	}
}