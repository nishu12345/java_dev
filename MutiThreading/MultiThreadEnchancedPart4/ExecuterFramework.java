import java.util.concurrent.*;

class MyThread implements Runnable{
	String name;
	MyThread(String name){
		this.name = name;
	}
	public void run(){
		try{
			System.out.println(name + "...Job started by Thread: " + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println(name + "...Job completed by Thread: " + Thread.currentThread().getName());
		}catch(InterruptedException e){
			System.out.println("My Thread got Interrupted");
		}
	}
}
class ExecutorFramework{
	public static void main(String... s){
		MyThread[] threads = {new MyThread("Durga"),new MyThread("Ravi"),new MyThread("Shiva"),
								new MyThread("Pavan"),new MyThread("Suresh"),new MyThread("Anil")};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(MyThread thread : threads){
			service.submit(thread);
		}
		service.shutdown();
	}
}