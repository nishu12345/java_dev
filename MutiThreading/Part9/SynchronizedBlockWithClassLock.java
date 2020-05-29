/*
	Display class has wish method with synchronized block on Display.class.
	So this synchronized block will need class level lock of Display. So 
	whether two different threads t1 & t2 are executing with two different 
	objects display1 and display2, the output will be regular. This is because
	when thread t1 gets the chance to execute with display1 object, thread t2
	has to wait with display2 object as it requires class level lock and it is
	currently with thread t1. Rest part of wish method i.e before the synchronized
	block and after the synchronized block will be executed parallely by both the
	threads.
*/

class Display{
	void wish(String name){
		System.out.println("Before Synchronized Block: " + name);
		synchronized(Display.class){
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
		System.out.println("After Synchronized Block:" + name);
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


class SynchronizedBlockWithClassLock{
	public static void main(String... s){
		Display display1 = new Display();
		MyThread mythread1 = new MyThread(display1,"Dhoni");
		Thread t1 = new Thread(mythread1);

		Display display2 = new Display();
		MyThread thread2 = new MyThread(display2,"Yuvraj");
		Thread t2 = new Thread(thread2);

		t1.start();
		t2.start();
	}

}