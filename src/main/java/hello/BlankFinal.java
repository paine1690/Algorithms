package hello;

public class BlankFinal {

	static class A{
		int a;
		public A(int a){
			this.a=a;
		}
	}
	
	private final int i=0;//直接初始化
	private final int j;//未初始化的空白final
	private final A a;//未初始化的空白final
	
	public BlankFinal(){//空白final必须在构造器中赋值，不然编译器会报错
		j=1; 
		a=new A(1);
	}
	
	public BlankFinal(int x){//空白final必须在构造器中赋值，不然编译器会报错
		j=x;
		a=new A(x);
	}
	
	public static void main(String[] args) {
	}

}

class WithFinals{
	private void f(){
		System.out.println("WithFinals.f()");
	}
}

class OverridingPrivate extends WithFinals{
	private void f(){
		System.out.println("OverridingPrivate.f()");
	}
}

class OverridingPrivate2 extends OverridingPrivate{
	public void f(){
		System.out.println("OverridingPrivate2.f()");
	}
}


