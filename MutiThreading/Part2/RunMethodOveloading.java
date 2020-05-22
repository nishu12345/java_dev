//case 4:- Overloading of run() method
class MyThread extends Thread{
	public void run(){
		System.out.println("no args run");
	}

	public void run(int i){
		System.out.println("int args run");
	}
}

class RunMethodOveloading{
	public static void main(String... s){
		MyThread t1 = new MyThread();
		t1.start();
	}
}