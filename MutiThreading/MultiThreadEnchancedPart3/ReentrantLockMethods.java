import java.util.concurrent.locks.*;


/*
	void lock() -> To get the lock if available or wait for it.

	boolean tryLock() -> To get the lock if available, otherwise perform alternative operations.
	
	boolean tryLock(long l,TimeUnit time) -> To get the lock if available, otherwise wait for specified time
												and if still lock is not available perform alternative operations.

	void lockInterruptibly() -> To get the lock if available, else wait for it. If in waiting period the thread
								got interrupted then lock will not get get.

	void unlock() -> To release the lock, or decrement lock hold count.

	int getHoldCount() -> Returns total lock hold count.

	boolean isHeldByCurrentThread() -> Returns true if lock is held by current thread.

	int getQueueLength() -> Returns total number of threads waiting for the lock.

	Collection getQueuedThreads() -> Returns Collection of threads waiting for the lock.

	boolean hasQueuedThreads() -> Returns true if any thread is waiting for the lock.

	boolean isLocked() -> Returns true if any thread has occupied the lock.

	boolean isFair() -> Returns true if fairness policy has been set to true.

	Thread getOwner() -> Return the thread which owns the lock.

*/
class ReentrantLockMethods{
	public static void main(String... s){
		ReentrantLock l = new ReentrantLock();
		l.lock();
		l.lock();
		System.out.println("Total Lock Hold Count > " + l.getHoldCount());
		System.out.println("Is Current Thread Holds The Lock > " + l.isHeldByCurrentThread());
		System.out.println("Is its lock held by any thread > " + l.isLocked());
		System.out.println("Is any threads waiting for this lock > " + l.hasQueuedThreads());
		System.out.println("How many threads are waiting for this lock > " + l.getQueueLength());
		l.unlock();
		System.out.println("Total Lock Hold Count > " + l.getHoldCount());
		l.unlock();
		System.out.println("Is its lock held by any thread > " + l.isLocked());
		System.out.println("Is it fair > " + l.isFair());
	}

}