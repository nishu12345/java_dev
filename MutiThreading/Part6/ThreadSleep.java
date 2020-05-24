/*
	sleep method is used to pause current thread for given amount of time.
*/

class ThreadSleep{
	public static void main(String... s)throws InterruptedException{
		for(int i = 0; i < 10; i++){
			System.out.println("Output - " + i);
			Thread.sleep(5000);
		}
	}
}