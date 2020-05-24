/*
	Here multiple threads are calling non-synchronized method wish, 
	with same object of Display i.e d, so inconsitent output is coming.
*/

class Display{
	public void wish(String name){
		for(int i = 0; i < 10; i++){
			System.out.print("Good Morning:");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println("I am interrupted");
			}
			System.out.println(name);
		}
	}
}

class MyThread implements Runnable{
	Display d;
	String name;
	MyThread(Display d,String name){
		this.d = d;
		this.name = name;
	}

	public void run(){
		d.wish(name);
	}
}

class NonSynchApproach{
	public static void main(String... s){
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