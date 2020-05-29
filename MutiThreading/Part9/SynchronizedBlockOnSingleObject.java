/*
	Here Display class have synchronized block. So when thread t1 is 
	calling wish() method it Before Synchronized Block is executed and 
	then t1 takes lock of current object and start executing synchronized
	block. Parallely thread t2 has also started executing wish method 
	with same object display as the method is not synchronized method level
	lock is not required. So Before Synchronized Block is printed with t2
	thread also. But when t2 want to execute synchronized block it needs the
	lock of display object which is currently occupied by thread t1. Then t2
	needs to wait for the lock of display object till thread t1 has not completed 
	its execution. Once thread t1 complete its execution of synchronized block, it
	releases the lock and t2 start executing the synchronized block.
*/


class Display{
	void wish(String name){
		System.out.println("Before Synchronized Block " + name);
		synchronized(this){
			try{
				for(int i = 0; i < 10; i++){
					System.out.print("Good Morning:");
					Thread.sleep(1000);
					System.out.println(name);
				}
			}catch(InterruptedException e){
				System.out.println("I am interrupted");
			}
		}
		System.out.println("After Synchronized Block " + name);
	}
}

class MyThread implements Runnable{
	Display display;
	String name;
	MyThread(Display display, String name){
		this.display = display;
		this.name = name;
	}

	public void run(){
		display.wish(name);
	}
}

class SynchronizedBlockOnSingleObject{

	public static void main(String... s){
		Display display = new Display();
		
		MyThread myThread1 = new MyThread(display,"Dhoni");
		Thread t1 = new Thread(myThread1);

		MyThread myThread2 = new MyThread(display,"Yuvraj");
		Thread t2 = new Thread(myThread2);

		t1.start();
		t2.start();
	}

}