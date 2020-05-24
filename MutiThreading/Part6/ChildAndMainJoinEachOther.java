/*
	Here main thread is calling join on child thread object, and
	child thread is calling join on main thread object. So both will
	wait for each other to complete there execution. This result in
	deadlock situation and neither of the thread will ever execute.
*/

class MyThread implements Runnable{
	static Thread mt;
	public void run(){
	try{
		mt.join();
	}catch(InterruptedException e){

	}
	for(int i = 0; i < 10; i++)
		System.out.println("Child Thread");	
	}
	
}

class ChildAndMainJoinEachOther{
	public static void main(String... s)throws InterruptedException{
		MyThread mythread = new MyThread();
		MyThread.mt = Thread.currentThread();
		Thread t = new Thread(mythread);
		t.start();
		t.join();
		for(int i = 0; i < 10; i++){
			System.out.println("Main Thread");
			Thread.sleep(2000);
		}
	}

}