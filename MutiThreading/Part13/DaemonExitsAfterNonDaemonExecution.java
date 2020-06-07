/*
	Once the last non-daemon thread completes its execution, all
	the daemon threads are terminated by default. 

	Here main thread is non-daemon thread and MyThread is daemon
	thread. Once main thread completes its execution, thread t1 
	will be terminated by default.
*/
class MyThread implements Runnable{
	public void run(){
		try{	
			for(int i = 0; i < 10; i++){
				System.out.println("Child Thread");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("MyThread got interrupted");
		}
	}
}

class DaemonExitsAfterNonDaemonExecution{
	public static void main(String... s){
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread);
		t1.setDaemon(true);
		t1.start();
		System.out.println("End of Main Thread");
	}
}