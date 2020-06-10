import java.util.concurrent.locks.*;

/*
	Here if any thread will get the lock it will execute if statement block,
	and other thread will try to get the lock, if not available will execute
	else statement block.
*/

class MyThread implements Runnable{
	static ReentrantLock l = new ReentrantLock();

	public void run(){
		try{
			if(l.tryLock()){
				System.out.println(Thread.currentThread().getName() + " performing thread safe operations");
				Thread.sleep(1000);
			}else{
				System.out.println(Thread.currentThread().getName() + " performing alternate operations");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("MyThread got interrupted");
		}
	}
}

class ReentrantTryLock{
	public static void main(String... s){
		MyThread myThread1 = new MyThread();
		Thread t1 = new Thread(myThread1);

		MyThread myThread2 = new MyThread();
		Thread t2 = new Thread(myThread2);
		t1.start();
		t2.start();
	}

}