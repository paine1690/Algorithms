package hello.multithreading;

public class MutliThreadDemo {
	public static void main(String[] args) {
		MyThread3 m1=new MyThread3();
        Thread t1=new Thread(m1, "Window 1");
        Thread t2=new Thread(m1, "Window 2");
        Thread t3=new Thread(m1, "Window 3");
        t1.start();
        t2.start();
        t3.start();	
	}
}

class MyThread3 implements Runnable{
	private int ticket=100;
	@Override
	public void run() {
		while(ticket>0){
			System.out.println(ticket--+" is saled by "+Thread.currentThread().getName());
		}		
	}	
}

class MyThread2 implements Runnable{
	 private int ticket=100;//每个线程都拥有100张票
	 public void run(){
	     while(ticket>0){
	         System.out.println(ticket--+" is saled by "+Thread.currentThread().getName());
	     }
	 }
}

class MyThread extends Thread{
	private int ticket=100;//每个线程都拥有100张票
	MyThread(String name){
        super(name);//调用父类带参数的构造方法
    }
	public void run(){
        while(ticket>0){
            System.out.println(ticket--+" is saled by "+Thread.currentThread().getName());
        }
    } 
}