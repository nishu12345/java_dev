//case5:- Not overriding run method
class MyThread extends Thread{

}

class NotOverridingRun{
	public static void main(String... s){
		MyThread t = new MyThread();
		t.start();
		/*
			As run method is not overriden by child thread, 
			the run() method from Thread class will be executed.
			And it has empty implementation.
		*/
	}
}