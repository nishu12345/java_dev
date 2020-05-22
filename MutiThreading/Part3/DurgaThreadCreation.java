class MyRunnable extends Thread{
	public void run(){
		System.out.println("Child Thread");
	}
}

class DurgaThreadCreation{
	public static void main(String... s){
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();

		System.out.println("Main Thread");
	}
}