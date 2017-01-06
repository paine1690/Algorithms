package hello.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExcutorDemo {

	public static void main(String[] args) {
		ExecutorService executor1=Executors.newFixedThreadPool(2);
		ExecutorService executor2=Executors.newCachedThreadPool();
		ExecutorService executor3=Executors.newSingleThreadExecutor();
		ExecutorService executor4=Executors.newScheduledThreadPool(2);	
		
		ThreadPoolExecutor e =new ThreadPoolExecutor(0, 0, 0, null, null);
		
	}

}
