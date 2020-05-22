/*case 9:-
	If a thread is already started, restarting that thread
	will throw IllegalThreadStateException at runtime.
*/
class MyThread extends Thread{
	public void run(){
		System.out.println("Child Thread");
	}
}
class RestartThread{
	public static void main(String... s){
		MyThread t = new MyThread();
		t.start();
		//restarting a thread cause IllegalThreadStateException
		t.start();
	}

}