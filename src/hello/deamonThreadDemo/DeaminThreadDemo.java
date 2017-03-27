package hello.deamonThreadDemo;

public class DeaminThreadDemo {

	public static void main(String[] args) {
		Thread threadA=new Thread(){
			public void run(){
				System.out.println("hello I am threadA");				
				Thread threadB=new Thread(){
					public void run(){
						System.out.println("hello I am threadB");
					}
				};
				System.out.println("threadB is deamon: "+threadB.isDaemon());
			}
		};
		System.out.println("threadA is deamon: "+threadA.isDaemon());
		threadA.setDaemon(true);
		threadA.start();
		System.out.println("threadA is deamon: "+threadA.isDaemon());
	}

}
