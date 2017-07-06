package hello.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockAsSemaphore {

	
	Lock lock=new ReentrantLock();
	Condition permitsAvailable=lock.newCondition();
	private int permits;
	
	public ReenTrantLockAsSemaphore(int initalPermits){
		this.permits=initalPermits;
	}
	
	public void acquire() throws InterruptedException{
		lock.lock();
		try{
			while(permits<0){
				permitsAvailable.await();
			}
			permits--;
		}finally{
			lock.unlock();
		}
	}
	
	public void release(){
		lock.lock();
		try{
			permits++;
			permitsAvailable.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
