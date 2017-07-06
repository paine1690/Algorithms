package hello.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


class DoSomethingImp implements Interface{
	@Override
	public void doSomthing() {
		System.out.println("something");			
	}

	@Override
	public void doSomthingElse(String s) {
		System.out.println("donthingElse: "+s);			
	}	
}

class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();  
    public Object getProxy(Class clazz) {  
        enhancer.setSuperclass(clazz); //① 设置需要创建子类的类  
        enhancer.setCallback(this);   
        return enhancer.create(); //②通过字节码技术动态创建子类实例     
    }      
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		System.out.println("开始");
		proxy.invokeSuper(obj, args);  
		System.out.println("结束");
		return null;	
	}	
}


public class CGLibDemo {
	
	static void consumer(Interface iface){
		iface.doSomthing();
		iface.doSomthingElse("lalala");		
	}
	
	public static void main(String[] args) {
		Interface real=new DoSomethingImp();
		consumer(real);
		CglibProxy cglib=new CglibProxy();  
		DoSomethingImp bookCglib=(DoSomethingImp)cglib.getProxy(DoSomethingImp.class);  
		consumer(bookCglib);
	}
}
