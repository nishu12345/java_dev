/*
	Display class has one synchronized block which needs lock of current object.
	And there are two object display1 and display2 whose locks are occupied by
	thread t1 and t2. So both the thread will continue its execution parallely.
	And no thread needs to wait for object lock of other. So instead of creating
	a synchronized block the output will be irregular.
*/

class Display{

	void wish(String name){
		System.out.println("Before Synchronized Block: " + name);
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
		System.out.println("After Synchronized Block: " + name);
	}
	
}

class MyThread implements Runnable{
	Display display;
	String name;
	MyThread(Display display,String name){
		this.display = display;
		this.name = name;
	}

	public void run(){
		display.wish(name);
	}
}

class SynchronizedBlockWithTwoObjects{
	public static void main(String... s){
		Display display1 = new Display();
		MyThread thread1 = new MyThread(display1,"Dhoni");
		Thread t1 = new Thread(thread1);

		Display display2 = new Display();
		MyThread thread2 = new MyThread(display2, "Yuvraj");
		Thread t2 = new Thread(thread2);

		t1.start();
		t2.start();
	}
}