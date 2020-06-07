/*
	stop() method is used to stop the thread.
	When a thread is stopped it immediately enters into dead state.
*/

class MyThread implements Runnable{
	public void run(){
		try{
			for(int i = 0; i < 10; i++){
				System.out.println("Child Thread");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("MyThread is interrupted");
		}
	}
}

class StopThread{
	public static void main(String... s){
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread);
		t1.start();
		System.out.println("End of Main Thread");
		t1.stop();
	}
}