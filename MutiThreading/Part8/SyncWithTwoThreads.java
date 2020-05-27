/*
	Display class have two synchronized method displayn() and displayc().
	And two different threads(t1 & t2) wants to execute displayn() and
	displayc() respectively with same display object. Once thread t1 gets
	the lock of display object, other thread t2 has to wait fot t1 to 
	complete its execution. When thread t1 complete its execution, t2
	gets the lock of display object and will further complete its execution.
*/

class Display{
	synchronized void displayn(){
		try{
			for(int i = 1; i< 11; i++){
				System.out.print(i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("displayn am interrupted");
		}
	}

	synchronized void displayc(){
		try{
			for(int i = 65; i < 76; i++){
				System.out.print((char)i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("displayc has been interrupted");
		}
	}
}

class MyThreadN implements Runnable{
	Display display;
	MyThreadN(Display display){
		this.display = display;
	}

	public void run(){
		display.displayn();
	}
}

class MyThreadC implements Runnable{
	Display display;
	MyThreadC(Display display){
		this.display = display;
	}
	public void run(){
		display.displayc();
	}
}

class SyncWithTwoThreads{
	public static void main(String... s){
	Display display = new Display();

	MyThreadN myThreadN = new MyThreadN(display);
	Thread t1 = new Thread(myThreadN);
	MyThreadC myThreadC = new MyThreadC(display);
	Thread t2 = new Thread(myThreadC);

	t1.start();
	t2.start();	
	}
	

}