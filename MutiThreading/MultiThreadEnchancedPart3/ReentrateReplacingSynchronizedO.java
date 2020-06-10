import java.util.concurrent.locks.*;

/*
	Here ReentrantLock object is creating a lock around the lines of codes we want to 
	make it as synchronized. This is similar to object level lock in synchronization.
*/
class Display{
	ReentrantLock l = new ReentrantLock();
	
	void wish(String name){
		l.lock();

		

		try{
			for(int i = 0; i < 10; i++){
				System.out.print("Good Morning : ");
				Thread.sleep(1000);
				System.out.println(name);
				System.out.println(l.hasQueuedThreads());

				System.out.println(l.getQueueLength());

			}
		}catch(InterruptedException e){
			System.out.println("Display got interrupted");
		}
		l.unlock();
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



class ReentrateReplacingSynchronizedO{
	public static void main(String... s){
		
		Display d = new Display();
		MyThread myThread1 = new MyThread(d,"Dhoni");
		Thread t1 = new Thread(myThread1);

		
		MyThread myThread2 = new MyThread(d,"Yuvraj");
		Thread t2 = new Thread(myThread2);

		t1.start();
		t2.start();
	}
}