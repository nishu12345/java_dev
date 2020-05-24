/*
	Here main thread call join method on object of itself.
	So main thread wants to wait until main thread has completed
	its execution. This result in deadlock situation.
*/

class MainThreadJoinItself{
	public static void main(String... s)throws InterruptedException{
		Thread.currentThread().join();
	}
}