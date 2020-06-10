import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/*
	Any thread that get the lock will go into sleep for 30 seconds. 
	Another thread will try to get the lock and wait for 5 seconds and
	then will retry again. Once second thread get the lock it will also 
	sleep for 30 seconds and then break out of the while loop.
*/

class MyThread implements Runnable{
	static ReentrantLock lock = new ReentrantLock();
	public void run(){
		do{
			try{
				if(lock.tryLock(5000,TimeUnit.MILLISECONDS)){
					System.out.println(Thread.currentThread().getName() + " got the lock");
					Thread.sleep(30000);
					System.out.println(Thread.currentThread().getName() + " releases the lock");
					lock.unlock();
					break;
				}else{
					System.out.println(Thread.currentThread().getName() + " unable to get the lock, but will try again");
				}
			}catch(InterruptedException e){
				System.out.println("MyThread got interrupted");
			}
		}while(true);
	}
}

class ReentrantTryWithTimePeriod{
	public static void main(String... s){
		MyThread myThread1 = new MyThread();
		Thread t1 = new Thread(myThread1, "First Thread");

		MyThread myThread2 = new MyThread();
		Thread t2 = new Thread(myThread2, "Second Thread");

		t1.start();
		t2.start();
	}
}