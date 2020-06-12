class ThreadLocalOverrideInitial{
	public static void main(String... s){
		ThreadLocal tl = new ThreadLocal(){
			public Object initialValue(){
				return "abc";
			}
		};

		System.out.println("Thread Local Initial Value > " + tl.get());
		tl.set("Durga");
		System.out.println("Thread Local Value after set() method > " + tl.get());
		tl.remove();
		System.out.println("Thread Local Value after remove() method > " + tl.get());
	}
}