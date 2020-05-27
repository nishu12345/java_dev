/*
	Below example has two different biryani objects and two different dog threads.
	So both the dogs can eat biryani from two different biryani objects simultaneously.
	synchronized() functionallity comes to picture when there is only one Biryani object.
*/

class Biryani{
	synchronized void eat(String name){
		try{
			for(int i = 0; i< 10; i++){
				System.out.println(name + " is eating biryani..Kindly Wait!!");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("I am interrupted");	
		}
	}
}

class Dog implements Runnable{
	private Biryani biryani;
	private String name;

	Dog(Biryani biryani, String name){
		this.biryani = biryani;
		this.name = name;
	}

	public void run(){
		biryani.eat(name);
	}
}

class SyncWithTwoObject{
	public static void main(String... s){
		Biryani b = new Biryani();
		Dog d1 = new Dog(b,"First Dog");
		Thread t1 = new Thread(d1);

		Biryani b2 = new Biryani();
		Dog d2 = new Dog(b2,"Second Dog");
		Thread t2 = new Thread(d2);

		t1.start();
		t2.start();
	}

}