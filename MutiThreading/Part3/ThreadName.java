// We can assign the name of the thread, but if not defined, by default 
//jvm provides a name like Thread-0.

class MyThread extends Thread{
	public void run(){

		for(int i = 0; i < 10; i++)
		System.out.println(Thread.currentThread().getName());
	}
}



class ThreadName{
	public static void main(String... s){
		System.out.println(Thread.currentThread().getName());
		MyThread t = new MyThread();
		System.out.println(t.getName());
		Thread.currentThread().setName("Pawan Kalyan");
		System.out.println(Thread.currentThread().getName());
		// System.out.println(10/0);

		System.out.println("-------------------------------------------");
		t.setName("child thread");
		t.start();
		for(int i = 0; i < 10; i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
}