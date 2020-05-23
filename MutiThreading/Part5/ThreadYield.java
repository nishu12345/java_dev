/*
Thread.yield() method pauses it process and gives chance to other process of same priority.
If other waiting thread are of low priority then the current executing thread can continue
its execution.
Once the current executing thread has called Thread.yield() method it goes back to 
Ready/Runnable state and wait for Thread Scheduler to allocate the process.
*/
class MyThread implements Runnable{
	public void run(){
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Child Thread");
			Thread.yield();
		}
	}
}
class ThreadYield{

	public static void main(String... s){
		MyThread myThread = new MyThread();
		Thread t = new Thread(myThread);
		t.start();

		for(int i = 0; i < 10; i++){
			System.out.println("Main Thread");
			Thread.yield();
		}
	}

}