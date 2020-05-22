/*case 6:-
	When we override start() method the main thread only execute the start method
	from Child Thread. Nor any new thread is created neither run() method is executed.
*/
class MyThread extends Thread{
	public void run(){
		System.out.println("Run Method");
	}

	public void start(){
		super.start();//This will call the start() method of Thread class and that will
		// execute run() method of child method.
		System.out.println("Start Method");
	}

	

}

class OverrideStart{
	public static void main(String... s){
		MyThread t = new MyThread();
		t.start();

		System.out.println("Main Method");
	}
}