/*
	interrupt method interrupt the thread which is in blocked or sleep thread.
	Below main thread is interrupting child thread while child thread is going
	in sleep state, and thus child thread will throw InterruptedException.
*/

class MyThread implements Runnable{
	public void run(){
		try{
			for(int i = 0; i < 10; i++){
				System.out.println("I am lazy method");
				Thread.sleep(2000);
			}
		}catch(InterruptedException e){
			System.out.println("I got Interrupted");
		}
	}
}

class ThreadInterrupt{

	public static void main(String... s){
		MyThread mythread = new MyThread();
		Thread t = new Thread(mythread);
		t.start();
		t.interrupt();

		System.out.println("End of Main Method");
	}
}