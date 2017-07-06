package hello.multithreading;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	static class MyThread implements Runnable{
		private CyclicBarrier barrier;		
		public MyThread(CyclicBarrier barrier){
			this.barrier=barrier;
		}
		
		@Override
		public void run() {
			try{
				System.out.println("worker is waiting");
				barrier.await();
				System.out.println("ID:"+Thread.currentThread().getId()+" Working");
			}catch(Exception e){
				
			}
		}
	}
	
	public static void main(String[] args) {
		CyclicBarrier barrier=new CyclicBarrier(5, new Runnable(){
			@Override
			public void run() {
				System.out.println("Inseide barrier");				
			}
			
		});
		for(int i=0; i<5; i++){
			new Thread(new MyThread(barrier)).start();
		}		
	}
}
