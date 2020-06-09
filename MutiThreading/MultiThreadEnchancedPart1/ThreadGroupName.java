class ThreadGroupName{
	public static void main(String... s){
		System.out.println("Current Thread Group Name > " + Thread.currentThread().getThreadGroup().getName());
		System.out.println("Current Thread Parent Group Name > " + Thread.currentThread().getThreadGroup().getParent().getName());

		//create a thread group
		ThreadGroup g1 = new ThreadGroup("First Thread Group");
		System.out.println("First Thread Group Parent Group Name > " + g1.getParent().getName());

		//create a thread group inside another thread group
		ThreadGroup g2 = new ThreadGroup(g1,"Second Thread Group");
		System.out.println("Second Thread Group Parent Group Name > " + g2.getParent().getName());
	}
}