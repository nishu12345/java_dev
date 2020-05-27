/*
	Below two threads are using two different display objects. 
	So infact wish() method is synchronized, we are getting unstructured output.
	This is because both the threads are executing simultaneously and whichever thread
	is getting the processor it is printing its output. Thread t1 is getting the 
	lock of Display object d1 and Thread t2 is getting the lock of Display object d2.
*/

class Display{
	synchronized void wish(String name){
		try{
			for(int i = 0; i < 10; i++){
				System.out.print("Good Morning : ");
				Thread.sleep(1000);
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


class SyncWithTwoObjects{
	public static void main(String... s){
		Display d1 = new Display();
		Display d2 = new Display();

		MyThread myThread1 = new MyThread(d1,"Dhoni");
		Thread t1 = new Thread(myThread1);

		MyThread myThread2 = new MyThread(d2,"Yuvraj");
		Thread t2 = new Thread(myThread2);

		t1.start();
		t2.start();
	}
}