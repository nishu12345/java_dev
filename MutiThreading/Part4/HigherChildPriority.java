/*
	Higher priority thread is executed first followed by lower priority threads.
	So in below example child thread is executed first and then main thread will
	be executed as by default main thread gets priority 5, and we are setting
	the child thread priority as 10.
	But some platforms does not support thread priority and so we get mixed output.
*/
class MyThread extends Thread{
	public void run(){
		for(int i = 0; i < 100; i++){
			System.out.println("Child Thread");
		}
	}
}

class HigherChildPriority{

	public static void main(String... s){
		MyThread t = new MyThread();
		t.setPriority(10);
		t.start();

		for(int i = 0; i < 100; i++){
			System.out.println("Main Thread");
		}
	}

}