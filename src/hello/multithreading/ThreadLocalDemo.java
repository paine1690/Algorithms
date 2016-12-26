package hello.multithreading;

public class ThreadLocalDemo {

	private static final ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue(){
			return 0;
		}		
	};
	
	
	static class MyThread implements Runnable{
		int id;
		
		public MyThread(int id){
			this.id=id;
		}
		
		public void run(){
			System.out.println("线程: "+id+"初始值： "+value.get());
			for(int i=0; i<10; i++){
				value.set(value.get()+1);
			}
			System.out.println("线程: "+id+"累加值： "+value.get());
		}
	}
	
	
	public static void main(String[] args) {
		for(int i=0; i<3; i++){
			new Thread(new MyThread(i)).start();
		}
	}
}

