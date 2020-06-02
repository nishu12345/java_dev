/*
	Here main thread and mythread are communication with each other.
	Let's assume main thread got execution chance first, then following 
	will be the output order:-
	Main Thread Calling Wait Method
	Child Thread Starting Calculation
	Child Thread Giving Notification
	Main Thread Get Notification
	5050
*/
class MyThread implements Runnable{
	int total = 0;

	public void run(){
		synchronized(this){
			System.out.println("Child Thread Starting Calculation");
			for(int i = 1; i < 101; i++){
				total += i;
			}
			System.out.println("Child Thread Giving Notification");
			this.notify();
		}
	}
}

class MainAndMyThreadCommunication{
	public static void main(String... s)throws InterruptedException{
		MyThread myThread = new MyThread();
		Thread t = new Thread(myThread);
		t.start();

		synchronized(myThread){
			System.out.println("Main Thread Calling Wait Method");
			myThread.wait();
			System.out.println("Main Thread Get Notification");
			System.out.println(myThread.total);
		}
	}
}