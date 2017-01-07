package hello.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCPrinter implements Runnable{
	
	private static int cnt=1;
	private static Object lock=new Object();
	private int num;
	
	
	public ABCPrinter(int num){
		this.num=num;	
	}
	
	public void run(){
		while(true){
			synchronized(lock){
				while(cnt%3!=num){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println((char)('A'+num));
				cnt++;
				lock.notifyAll();
			}
		}
	}
	
	/*
	 * await与notify
	 */
	static Lock lock2=new ReentrantLock();
	static Condition[] conditions=new Condition[]{lock2.newCondition(), lock2.newCondition(), lock2.newCondition()};

	
	static class Printer implements Runnable{
		private int num;
		private Condition[] conditions;
		
		public Printer(int num, Condition[] conditions){
			this.num=num;
			this.conditions=conditions;
		}
		
		
		@Override
		public void run() {
			while(true){
				lock2.lock();;
				try{
					while(cnt%3!=num){
						try {
							conditions[num].await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println((char)('A'+num));
					cnt++;
					conditions[cnt%3].signal();					
				}finally{
					lock2.unlock();
				}
			}
		}		
	}	

	public static void main(String[] args) {
//		new Thread(new ABCPrinter(0)).start();
//		new Thread(new ABCPrinter(1)).start();
//		new Thread(new ABCPrinter(2)).start();
		//方法二
		new Thread(new Printer(0, conditions)).start();
		new Thread(new Printer(1, conditions)).start();
		new Thread(new Printer(2, conditions)).start();
	}
}
