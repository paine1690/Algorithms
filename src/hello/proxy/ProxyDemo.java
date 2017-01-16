package hello.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


//被代理的接口
interface Interface{
	void doSomthing();
	void doSomthingElse(String s);
}

class RealObject implements Interface{

	@Override
	public void doSomthing() {
		System.out.println("something");			
	}

	@Override
	public void doSomthingElse(String s) {
		System.out.println("donthingElse: "+s);			
	}	
}

class DynamicProxyHandler implements InvocationHandler{
	Object proxied;
	
	public DynamicProxyHandler(Object proxied){
		this.proxied=proxied;
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("****proxy: "+proxy.getClass()+
				", method: "+method+
				", args: "+Arrays.toString(args));
		return method.invoke(proxied, args);
	}		
}

public class ProxyDemo {		
	static void consumer(Interface iface){
		iface.doSomthing();
		iface.doSomthingElse("lalala");		
	}
	
	public static void main(String[] args) {
		Interface real=new RealObject();
		consumer(real);
		Interface proxy=(Interface) Proxy.newProxyInstance(real.getClass().getClassLoader(), real.getClass().getInterfaces(), new DynamicProxyHandler(real));
		consumer(proxy);
	}

}
