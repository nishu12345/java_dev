/*
	Here we are defining seperate Parent's Thread Local value for parent and child
	by overriding childValue() method.
*/

class ParentThread implements Runnable{
	static InheritableThreadLocal tl = new InheritableThreadLocal(){
		public Object childValue(Object p){
			return "Child Thread Local Value";
		}
	};

	public void run(){
		tl.set("Parent Thread Local Value");
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


class ThreadLocalInheritableChildValue{
	public static void main(String... s){
		ParentThread parentThread = new ParentThread();
		Thread parent = new Thread(parentThread);
		parent.start();
	}
}