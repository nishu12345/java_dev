/*
	Parent's ThreadLocal value will only be available in the lines of code executed by parent thread.
	So when Child thread is accessing the Parent's ThreadLocal value it is coming as null.
	Also when main thread is accessing the Parent's ThreadLocal value it is null.
*/

class ParentThread implements Runnable{
	static ThreadLocal threadLocal = new ThreadLocal();

	public void run(){
		threadLocal.set("Parent Thread");
		System.out.println("Parent's ThreadLocal Value in Parent Thread > " + threadLocal.get());
		ChildThread childThread = new ChildThread();
		Thread child = new Thread(childThread);
		child.start();
	}
}

class ChildThread implements Runnable{
	public void run(){
		System.out.println("Parent's ThreadLocal Value in Child Thread > " + ParentThread.threadLocal.get());
	}
}

class ThreadLocalInheritance{
	public static void main(String... s){
		ParentThread parentThread = new ParentThread();
		Thread parent = new Thread(parentThread);
		parent.start();
		System.out.println("Parent's ThreadLocal value in Main Thread > " + ParentThread.threadLocal.get());
	}

}