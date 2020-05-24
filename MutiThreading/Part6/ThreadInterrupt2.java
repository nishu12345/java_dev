/*
	interrupt method waits until the thread on which it is called, goes to 
	waiting or sleeping state. Once the thread goes to sleeping or waiting state
	interrupt method is executed, and InterruptedException is thrown. If the 
	thread on which interrupt method is called never goes to sleeping or waiting
	state, then interrupt method will not be executed.
*/

class MyThread implements Runnable{
	public void run(){
		for(int i = 0; i< 10000; i++)
			System.out.println("I am lazy thread");
		System.out.println("I am going into sleeping state");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			System.out.println("I am interrupted");
		}
	}
}
class ThreadInterrupt2{
	public static void main(String... s){
		MyThread myThread = new MyThread();
		Thread t = new Thread(myThread);
		t.start();
		t.interrupt();

		System.out.println("End of Main Method");
	}

}