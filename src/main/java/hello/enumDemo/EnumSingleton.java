package hello.enumDemo;

public class EnumSingleton {
	
	private EnumSingleton(){}
	
	public static EnumSingleton getInstance(){
		return Singleton.INSTANCE.getInstance();
	}
	
	private static enum Singleton{
		INSTANCE;
		
		private EnumSingleton singleton;		
		
		private Singleton(){
			singleton=new EnumSingleton();
		}
		
		public EnumSingleton getInstance(){
			return singleton;
		}		
	}
	
	public static void main(String[] args) {
		EnumSingleton a=EnumSingleton.getInstance();
		EnumSingleton b=EnumSingleton.getInstance();
		System.out.println(a==b);//true
	}
}
