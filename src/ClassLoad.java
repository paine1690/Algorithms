
public class ClassLoad {
	
	
	
	static class A implements Runnable{
		public void run(){
			synchronized(ClassLoad.class){
				try{
					ClassLoad.class.wait();
					System.out.println("aaa");
				}catch(Exception w){
					
				}
			}
		}
	}
	
	static class B implements Runnable{
		public void run(){
			synchronized(ClassLoad.class){
				System.out.println("bbb");
				ClassLoad.class.notifyAll();
				System.out.println("bbbbbbb");
			}
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		new Thread(new A()).start();
		Thread.sleep(1000);
		new Thread(new B()).start();
		
	}

}
