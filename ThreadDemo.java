class MyRunnable implements Runnable{
	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println("Child Thread");
		}
	}
}

class ThreadDemo{

	public static void main(String... s){
	
	MyRunnable r = new MyRunnable();
	Thread thread1 = new Thread(r);
	thread1.start();

	Runnable r2 = () -> {
		for(int i = 0; i < 10; i++)
		System.out.println("Lambda Child thread");
	};
	
	Thread thread2 = new Thread(r2);
	thread2.start();

	//thread2.run();


	for(int j = 0; j < 10; j++){
		System.out.println("Main Thread");
	}

	
	

	}
}
