import java.util.concurrent.*;

class MyCallable implements Callable{
	int num;
	MyCallable(int num){
		this.num = num;
	}

	public Object call()throws Exception{
		System.out.print(Thread.currentThread().getName() + "...calculating sum of first " + num + " numbers = ");
		int sum = 0;
		for(int i = 1; i <= num; i++){
			sum+=i;
		}
		return sum;
	}
}

class CallableExample{
	public static void main(String... s)throws Exception{
		MyCallable[] callables = {new MyCallable(10),new MyCallable(20),new MyCallable(30),
									new MyCallable(40),new MyCallable(50),new MyCallable(60)};

		ExecutorService service = Executors.newFixedThreadPool(3);
		for(MyCallable callable : callables){
			Future result = service.submit(callable);
			System.out.println(result.get());
		}
		service.shutdown();
	}
}