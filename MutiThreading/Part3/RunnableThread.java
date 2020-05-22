/*
Runnable is an interface by which we can define a thread.
It is the recommended way of implementing the thread.
*/
class MyRunnable implements Runnable{
	public void run(){
		System.out.println("Child Thread");
	}
}


class RunnableThread{

	public static void main(String... s){
		MyRunnable runnable = new MyRunnable();
		Thread t = new Thread(runnable);
		t.start();

		System.out.println("Main Thread");
	}

}