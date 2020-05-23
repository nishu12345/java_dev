/*join method is called if some thread want to wait for other thread execution to finish.
If Thread t1 wants to wait for Thread t2 to complete then join method will be called from
t1 on t2 object, and t1 will goes to waiting state until t2 completes.
Once t2 is completed, t1 will again goes to Ready/Runnable state and wait for Thread Scheduler
to allocate the process.
Also join() method throws InterruptedException and as it is a checked exception, it should
be handled else compile time exception will be thrown.
*/

class MyThread implements Runnable{
	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println("Child Thread");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){

			}
		}
	}
}

class MainThreadJoinChild{

	public static void main(String... s)throws InterruptedException{
		MyThread myThread = new MyThread();
		Thread t = new Thread(myThread);
		t.start();
		
		// main thread has called join method on Thread t, so main thread will wait until completing child Thread
		t.join();

		/*
			main thread will only wait for 10000ms for Child thread, after that main thread will continue
			with the execution.
		*/
		t.join(10000);

		for(int i = 0; i < 10; i++){
			System.out.println("Main Thread");
		}
	}
}