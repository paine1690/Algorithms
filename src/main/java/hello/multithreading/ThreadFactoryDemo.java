package hello.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryDemo implements Runnable{

	static class WorkerThread extends Thread{
		private Runnable target;
		
		public WorkerThread(Runnable target, int cnt){
			super(String.valueOf(cnt));
			this.target=target;
		}
		
		public void run(){
			try{
				target.run();
			}finally{				
				System.out.println(Thread.currentThread().getName()+"end");
			}
		}		
	}	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService=Executors.newCachedThreadPool(new ThreadFactory(){
			private AtomicInteger count=new AtomicInteger();			
			@Override
			public Thread newThread(Runnable r) {
				int cnt=count.incrementAndGet();
				System.out.println("Thread: "+cnt+" created");						
				return new WorkerThread(r, cnt);
			}
		});
		
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		System.out.println("shutdown");
		executorService.shutdown();
 
	}
	@Override
	public void run() {
		System.out.println("Thread: "+Thread.currentThread().getName()+" run");		
	}
}
