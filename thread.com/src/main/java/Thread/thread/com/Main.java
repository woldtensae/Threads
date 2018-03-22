package Thread.thread.com;

public class Main {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread(), "t1");
		t1.start();
		Thread t2 = new MyThread2("t2");
		t2.start();
		System.out.println("The last statment!!");
	}
}

class MyThread implements Runnable{
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(10000);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		myTasks();
	}
	
	public void myTasks() {
		for(int i=0;i<100000;i++) {
			
		}
	}
}

class MyThread2 extends Thread{
	public MyThread2(String threadName) {
		super(threadName);
	}
	
	public void run() {
		try {
			Thread.sleep(10000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		someBigProcess();
	}
	public void someBigProcess() {
		try {
			Thread.sleep(10000);
			System.out.println(Thread.currentThread().getName());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

