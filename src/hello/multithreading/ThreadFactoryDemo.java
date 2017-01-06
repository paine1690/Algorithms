package hello.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryDemo implements Runnable{

	static class WorkerThread extends Thread{
		private Runnable target;
		private AtomicInteger counter;	
		
		public WorkerThread(Runnable target, AtomicInteger counter){
			this.target=target;
			this.counter=counter;
		}
		
		public void run(){
			try{
				target.run();
			}finally{
				int c=counter.incrementAndGet();
				System.out.println("terminate no " + c + " Threads");
			}
		}		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService=Executors.newCachedThreadPool(new ThreadFactory(){
			private AtomicInteger count=new AtomicInteger();			
			@Override
			public Thread newThread(Runnable r) {
				int c=count.incrementAndGet();
				System.out.println("create no " + c + " Threads");						
				return new WorkerThread(r, count);
			}
		});
		
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.execute(new ThreadFactoryDemo());
		executorService.shutdown();
 
	}
	@Override
	public void run() {
		System.out.println("run");
		
	}
}
