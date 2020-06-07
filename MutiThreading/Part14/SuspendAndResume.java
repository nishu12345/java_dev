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

class SuspendAndResume{
	public static void main(String... s){
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread);
		t1.start();
		System.out.println("Suspending Child Thred");
		t1.suspend();
		System.out.println("Resuming Suspneded Child Thread");
		t1.resume();
	}
}