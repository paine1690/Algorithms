package hello.multithreading;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage {

	
    private final int MAX_SIZE = 100;// 仓库最大存储量    
      
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>();// 仓库存储的载体
    

    // 生产num个产品  
	public void produce(int num, Thread thread){
			// 如果仓库剩余容量不足  
			System.out.println(thread.getName());
			if(list.size()==MAX_SIZE){
				System.out.println("【库存量】:" + MAX_SIZE + "/t暂时不能执行生产任务!");  
			}
			// 生产条件满足情况下，生产num个产品  
			for(int i=0; i<num; i++){
				try{
					list.put(new Object());// 放入产品，如果满了会自动阻塞  
				}catch(InterruptedException e){
					
				}
			}
			System.out.println("【现仓储量为】:" + list.size());  
	}
	
	// 消费num个产品  
	public void consume(int num, Thread thread){

			// 如果仓库存储量不足  
			System.out.println(thread.getName());
			if(list.size()==0){
				System.out.println("【库存量】:0/t暂时不能执行生产任务!");  
			}
			// 消费条件满足情况下，消费num个产品  
            for(int i=0; i<num; i++){
            	try{
            		list.take();
            	}catch(InterruptedException e){
            		
            	}
            }
            System.out.println("【现仓储量为】:" + list.size());  
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
	/*
	 * 其余代码与上面完全
	 */
	
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
