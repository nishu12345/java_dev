/*
	All list of thread names in system group
*/
class ActiveThreadsInSystemGroup{
	public static void main(String... s){
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup().getParent();
		Thread[] allThreads = new Thread[threadGroup.activeCount()];

		threadGroup.enumerate(allThreads);
		for(Thread t : allThreads){
			System.out.println(t.getName() + " Is Daemon " + t.isDaemon());
		}
	}
}