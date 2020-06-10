import java.util.concurrent.locks.*;


/*
	Here there are two Biryani objects and two different Dog threads. But only one dog is allowed
	to eat biryani, and other thread needs to wait for the ReentrantLock. This is similar to class
	level lock in synchronization.
*/
class Biryani{
	static ReentrantLock l = new ReentrantLock();

	void serve(String dogName){
		l.lock();
		try{
			for(int i = 0; i < 10; i++){
				System.out.println(dogName + " eating biryani from ");	
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("Biryani got interrupted");
		}
		l.unlock();
	}
}

class DogThread implements Runnable{
	Biryani biryani;
	String dogName;

	DogThread(Biryani biryani, String dogName){
		this.biryani = biryani;
		this.dogName = dogName;
	}

	void eat(){
		biryani.serve(dogName);
	}

	public void run(){
		eat();
	}
}

class ReentrantReplacingSynchronizedC{
	public static void main(String... s){

		Biryani biryani1 = new Biryani();
		DogThread dogThread1 = new DogThread(biryani1,"Dog 1");
		Thread dog1 = new Thread(dogThread1);

		

		Biryani biryani2 = new Biryani();
		DogThread dogThread2 = new DogThread(biryani2, "Dog 2");
		Thread dog2 = new Thread(dogThread2);
		dog1.start();
		dog2.start();
	}

}