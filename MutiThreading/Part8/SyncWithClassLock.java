/*
	In class Display wish method is static and synchronized.
	So when two different threads(t1 & t2) wants to execute with two different
	objects(d1 & d2) the method wish(), each threads required class level lock.
	So while t1 has class level lock with object d1, t2 has to wait for that 
	lock with d2 and thus one thread will complete its execution and then 
	other thread will get the chance to execute.
*/

class Display{
	static synchronized void wish(String name){
		try{
			for(int i = 0; i < 10; i++){
				System.out.print("Good Morning: ");
				Thread.sleep(1000);
				System.out.println(name);
			}
		}catch(InterruptedException e){
			System.out.println("I am interrupted");
		}
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

class SyncWithClassLock{
	public static void main(String... s){
		Display d1 = new Display();
		Display d2 = new Display();

		MyThread myThread = new MyThread(d1,"Dhoni");
		Thread t1 = new Thread(myThread);

		MyThread myThread2 = new MyThread(d2,"Yuvraj");
		Thread t2 = new Thread(myThread2);

		t1.start();
		t2.start();
	}
}