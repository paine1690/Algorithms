package hello.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class WaitNotifyDemo {	
	static class Producer extends Thread{
		private Queue<Integer> queue;
		private int maxSize;
		
		public Producer(String name, Queue<Integer> queue, int maxSize){
			super(name);
			this.maxSize=maxSize;
			this.queue=queue;
		}
		
		public void run(){
			while(true){
				synchronized(queue){
					while(queue.size()==maxSize){
						System.out.println("The queue is full, producer wait");
						try{
							queue.wait();
						}catch(Exception e){							
						}
					}
					Random random = new Random(); 
				    int i = random.nextInt(); 
					queue.offer(i);
					System.out.println("Producing value : " + i); 
					queue.notifyAll();
				}
			}
		}
	}
	
	static class Consumer extends Thread{
		private Queue<Integer> queue;
		
		public Consumer(String name, Queue<Integer> queue){
			super(name);
			this.queue=queue;
		}
		
		public void run(){
			while(true){
				synchronized(queue){
					while(queue.isEmpty()){
						System.out.println("The queue is empty, "+getName()+"wait");
						try{
							queue.wait();
						}catch(Exception e){							
						}
					}
					int num=queue.poll();
					System.out.println(getName()+" get number: "+num);
					queue.notifyAll();
				}
			}
		}
	}
	
	public static void main(String[] args) {		
		Queue<Integer> queue=new LinkedList<Integer>();
		Producer producer=new Producer("producer", queue, 4);
		Consumer consumer1=new Consumer("consumer1", queue);
		Consumer consumer2=new Consumer("consumer2", queue);
		producer.start();
		consumer1.start();
		consumer2.start();
	}
}
