//case 2:- start() method vs run() method
class MyThread extends Thread{
	public void run(){
		System.out.println("Child Thread");
	}
}

class StartVsRun{
	public static void main(String... s){
		MyThread t = new MyThread();
		t.start(); //Child Thread will exexute run() method seperately

		t.run();// Main Thread will exeute run() method, as it is simple a function call.
	}
}