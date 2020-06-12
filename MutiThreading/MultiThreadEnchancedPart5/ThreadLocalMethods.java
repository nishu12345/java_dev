class ThreadLocalMethods{
	public static void main(String... s){
		ThreadLocal threadLocal = new ThreadLocal();
		System.out.println("Thread Local Initial Value > " + threadLocal.get());
		threadLocal.set("Durga");
		System.out.println("Thread Local Set Value  " + threadLocal.get());
		threadLocal.remove();
		System.out.println("Thread Local Value after remove() method > " + threadLocal.get());
	}
}