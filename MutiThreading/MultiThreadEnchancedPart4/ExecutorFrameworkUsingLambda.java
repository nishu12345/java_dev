import java.util.concurrent.*;
import java.util.function.*;
import java.util.*;
class ExecutorFrameworkUsingLambda{
	public static void main(String... s){
		Function<String,Runnable> runnableFunction = (name) -> {return new Thread(){
			public void run(){
				try{
					System.out.println(name + "...Job started by thread: " + Thread.currentThread().getName());
					Thread.sleep(1000);
					System.out.println(name + "...Job completed by thread: " + Thread.currentThread().getName());
				}catch(InterruptedException e){
					System.out.println(Thread.currentThread().getName() + "got interrupted");
				}		
			}			
		};};
		List<Runnable> runnables = Arrays.asList(runnableFunction.apply("Anil"),runnableFunction.apply("Durga"),runnableFunction.apply("Pavan"),
												runnableFunction.apply("Shiva"),runnableFunction.apply("Suresh"),runnableFunction.apply("Ravi"));
		ExecutorService service = Executors.newFixedThreadPool(3);
		runnables.stream().forEach(runnable -> service.submit(runnable));
		service.shutdown();
	}
}