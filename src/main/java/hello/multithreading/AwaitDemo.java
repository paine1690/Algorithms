package hello.multithreading;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitDemo {

	
    private final int MAX_SIZE = 100;// 仓库最大存储量    
      
    private LinkedList<Object> list = new LinkedList<Object>();// 仓库存储的载体
    
    private final Lock lock=new ReentrantLock();// 锁      
    private Condition full=lock.newCondition();// 仓库满的条件变量  
    private Condition empty=lock.newCondition();// 仓库空的条件变量  
    
	
    // 生产num个产品  
	public void produce(int num, Thread thread){
		lock.lock();
		try{//显示锁最后必须显示释放
			// 如果仓库剩余容量不足  
			System.out.println(thread.getName());
			while(list.size()+num>MAX_SIZE){
				System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:"  
                        + list.size() + "/t暂时不能执行生产任务!");  
				try{
					full.await();
				}catch(InterruptedException e){
					
				}
			}
			// 生产条件满足情况下，生产num个产品  
			for(int i=0; i<num; i++){
				list.add(new Object());
			}
			System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());  
            empty.signal();
		}finally{
			lock.unlock();
		}
	}
	
	// 消费num个产品  
	public void consume(int num, Thread thread){
		lock.lock();
		try{
			// 如果仓库存储量不足  
			System.out.println(thread.getName());
			while(list.size()<num){
				System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"  
                        + list.size() + "/t暂时不能执行消费任务!");  
				try{
					empty.await();
				}catch(InterruptedException e){
					
				}
			}
			// 消费条件满足情况下，消费num个产品  
            for(int i=0; i<num; i++){
            	list.remove();
            }
            System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());  
            full.signal();
		}finally{
			lock.unlock();
		}
	}
	
	static class Producer extends Thread{
		Storage storage;// 所在放置的仓库  
		int num;// 每次生产的产品数量  
		
		public Producer(String name, Storage storage, int num){
			super(name);
			this.storage=storage;
			this.num=num;
		}
		
		public void run(){
			storage.produce(num, this);
		}
	}
	
	static class Consumer extends Thread{
		Storage storage;// 所在放置的仓库  
		int num;// 每次生产的产品数量  
		
		public Consumer(String name, Storage storage, int num){
			super(name);
			this.storage=storage;
			this.num=num;
		}
		
		public void run(){
			storage.consume(num, this);
		}
		
	}
	
	public static void main(String[] args) {		
        Storage storage = new Storage();  // 仓库对象  

        // 生产者对象  
        Producer p1=new Producer("producer1", storage, 10); 
        Producer p2=new Producer("producer2", storage, 10); 
        Producer p3=new Producer("producer3", storage, 10); 
        Producer p4=new Producer("producer4", storage, 10); 
        Producer p5=new Producer("producer5", storage, 10); 
        Producer p6=new Producer("producer6", storage, 10);
        Producer p7=new Producer("producer7", storage, 10);
        
        // 消费者对象  
        Consumer c1=new Consumer("consumer1", storage, 50);  
        Consumer c2=new Consumer("consumer2", storage, 50);  
        Consumer c3=new Consumer("consumer3", storage, 50);   
        
        // 线程开始执行  
        c1.start();  
        c2.start();  
        c3.start();  
        p1.start();  
        p2.start();  
        p3.start();  
        p4.start();  
        p5.start();  
        p6.start();  
        p7.start();
	}

}
