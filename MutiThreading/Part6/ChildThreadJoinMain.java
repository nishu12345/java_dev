/*
	Here child thread wants to wait until main thread is executed.
	For this child thread needs to call join method on main thread object.
	So we need to provide main thread object referencce to child thread.
	Below child thread will wait until main thread has completed its execution.
*/
class MyThread implements Runnable{
	static Thread mt;
	public void run(){
		try{
			mt.join();
		}catch(InterruptedException e){

		}

		for(int i = 0; i < 10; i++){
			System.out.println("Child Thread");
		}		
	}
}

class ChildThreadJoinMain{

	public static void main(String... s)throws InterruptedException{
	
		MyThread myThread = new MyThread();
		MyThread.mt = Thread.currentThread();
		Thread t = new Thread(myThread);
		t.start();

		for(int i = 0; i < 10; i++){
			System.out.println("Main Thread");
			Thread.sleep(2000);
		}

	}
	
}