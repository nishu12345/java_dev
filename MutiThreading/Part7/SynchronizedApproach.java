/*
	Here wish method inside Display class is made synchronized. Now any thread 
	want to execute wish method, it need the lock of Display d object. So if thread
	t1 get lock of d, rest other thread needs to wait for t1 to complete its execution
	and release the lock.
*/

class Display{
	public synchronized void wish(String name){
		try{
			for(int i = 0; i < 10; i++){
			System.out.print("Good Morning:");
			Thread.sleep(2000);
			System.out.println(name);
		}
		}catch(InterruptedException e){
			System.out.println("I am interrupted");
		}
		
	}
}

class MyThread implements Runnable{
	Display d;
	String name;
	MyThread(Display d, String name){
		this.d = d;
		this.name = name;
	}
	public void run(){
		d.wish(name);
	}
}
class SynchronizedApproach{

	public static void main(String... s)throws InterruptedException{
		Display d = new Display();
		
		MyThread myThread1 = new MyThread(d,"Dhoni");
		Thread t1 = new Thread(myThread1);
		
		MyThread myThread2 = new MyThread(d,"Yuvraj");
		Thread t2 = new Thread(myThread2);

		MyThread myThread3 = new MyThread(d,"Kholi");
		Thread t3 = new Thread(myThread3);

		MyThread myThread4 = new MyThread(d,"Raina");
		Thread t4 = new Thread(myThread4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}