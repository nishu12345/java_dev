class MyThread implements Runnable {
	public void run(){
		System.out.println("Child Thread");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println("I am interrupted");
		}
	}
}
class ThreadGroupMethods{
	public static void main(String... s){
		ThreadGroup parentGroup = new ThreadGroup("Parent Group");
		ThreadGroup childGroup = new ThreadGroup(parentGroup, "Child Group");

		MyThread myThread1 = new MyThread();
		Thread t1 = new Thread(parentGroup,myThread1);

		MyThread myThread2 = new MyThread();
		Thread t2 = new Thread(parentGroup,myThread2);

		t1.start();
		t2.start();

		System.out.println("Total Active Thread Count in Parent Group > " +parentGroup.activeCount());
		System.out.println("Total Active Thread Group Count in Parent Group > "+parentGroup.activeGroupCount());
		parentGroup.list();

		System.out.println("Main Thread Sleeping for 10 seconds");
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			System.out.println("Main Thread is Interrupted");
		}

		System.out.println("Total Active Thread Count in Parent Group > " + parentGroup.activeCount());
		System.out.println("Total Active Thread Group Count in Parent Group > " + parentGroup.activeGroupCount());
		parentGroup.list();

		


	}
}