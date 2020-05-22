//Introduction To Thread


//Defining a Thread.
class MyThread extends Thread{
	
	//Job of a thread that will be executed by child thread.
	public void run(){
		for(int i = 0; i < 100; i++){
		System.out.println("Child Thread");
		}
	}
	
}


class ThreadIntroduction{
	public static void main(String... s){
	
	//Creating instance of the child thread by main thread.
	MyThread t1 = new MyThread();
	//Starting the child thread by main thread.
	t1.start();

	

	//Below loop will be executed by main thread.
	for(int i = 0; i < 100; i++){
			System.out.println("Main Thread");
		}
	}
}