package hello.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public long timeTasks(int n, final Runnable task) throws InterruptedException{
		
		final java.util.concurrent.CountDownLatch startGate=new CountDownLatch(1);
		final CountDownLatch endGate=new CountDownLatch(n);
		
		for(int i=0; i<n; i++){
			Thread t=new Thread(){
				public void run(){
					try {
						startGate.await();//所有线程都要先等待，然后统一开始执行
						try{
							task.run();
						}finally{//latch.countDown()建议放在finally里面执行
							endGate.countDown();//执行之后count-，知道为0，代表所有线程执行完毕
						}
					} catch (InterruptedException e) {
					}
				}
			};
			t.start();
		}
		long start=System.nanoTime();
		startGate.countDown();//统一开始执行
		endGate.await();//等待所有线程执行完毕
		long end=System.nanoTime();
		return end-start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
