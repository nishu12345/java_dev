/*
	Here InheritableThreadLocal value is transmuted to its child threads.
	Like the change in value in parent thread is reflected to its child thread, 
	because child thread is born and started in parent thread. But parent's
	thread local value change is not reflected in main thread as Parent thread is the 
	child of main, but main is not the child of parent.
*/

class ParentThread implements Runnable{
	static InheritableThreadLocal tl = new InheritableThreadLocal();
	public void run(){
		tl.set("Parent Thread");
		System.out.println("Parent's Thread Local Value in Parent Thread > " + tl.get());
		ChildThread childThread = new ChildThread();
		Thread child = new Thread(childThread);
		child.start();
	}
}

class ChildThread implements Runnable{
	public void run(){
		System.out.println("Parent's Thread Local Value in Child Thread > " + ParentThread.tl.get());
	}
}

class ThreadLocalInheritable{
	public static void main(String... s){
		ParentThread parentThread = new ParentThread();
		Thread parent = new Thread(parentThread);
		parent.start();

		System.out.println("Parent's Thread Local Value in Main Thread > " + ParentThread.tl.get());
	}
}