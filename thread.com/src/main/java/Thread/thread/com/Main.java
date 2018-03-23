package Thread.thread.com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread(), "t1");
		t1.start();
		Thread t2 = new MyThread2("t2");
		t2.start();
		List<Employee> list = new ArrayList<Employee>();
		System.out.println("The last statment!!");
		list.add( new Employee("aman", 1000));
		list.add( new Employee("belete", 4000));
		list.add( new Employee("abebe", 2000));
		list.add( new Employee("aman", 2000));
		
		list.sort(new Comparator<Employee>() {

			public int compare(Employee o1, Employee o2) {
				if(o1.getFirstName().compareTo(o2.getFirstName())==0) {
					if(o1.getSalary()-o2.getSalary() > 0)
						return 1;
					else if(o1.getSalary()-o2.getSalary() < 0)
						return -1;
					return 0;
				}
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
			
		});
		
		for(Employee emp: list) {
			System.out.println(emp.getFirstName() + "      " + emp.getSalary() );
		}
		
	}
}

class Employee{
	private String firstName;
	private double salary;
	public Employee(String firstName, double salary){
		this.firstName = firstName;
		this.salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
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

