class MyThread implements Runnable{
	public void run(){
		System.out.println("Child Thread");
	}
}
class Test{
	public static void main(String... s){
		MyThread myThread = new MyThread(){
			public void run(){
				System.out.println("Anonymous Class");
			}
		};
		Thread t = new Thread(myThread);
		t.start();
	}
}