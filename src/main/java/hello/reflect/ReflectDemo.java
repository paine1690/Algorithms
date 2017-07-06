package hello.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectDemo {  
  public static void getMethodInfo(String className) {
    try {
      Class clazz = Class.forName(className);
      Method[] methods = clazz.getMethods();
      for (Method method : methods) {
        getMethodParametersinfo(method);
      }      
    } catch(Exception e) {
      e.printStackTrace();
    }
  } 
  
  private static void getMethodInfo(Method method) {
    System.out.println("method name: " + method.getName());
    Class<?>[] parameterTypes = method.getParameterTypes();
    for (Class<?> clas : parameterTypes) {
      System.out.println("arg type: " + clas.getName());
    }
    System.out.println("---------------------------------");
  }

  private static void getMethodParametersinfo(Method method) {
    System.out.println("method name: " + method.getName());
    Parameter [] paramaters = method.getParameters();
    for (Parameter paramater : paramaters) {
      System.out.print("arg name: " + paramater.isNamePresent() + " " + paramater.getName());
      System.out.println(", arg type: " + paramater.getParameterizedType());
    }
    System.out.println("---------------------------------");    
  }
  public static void main(String[] args) {
    getMethodInfo("hello.reflect.ClassA");    
  }
}
