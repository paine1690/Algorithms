package hello;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo {

  public static void main(String[] args) {
    Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    
    
    Runnable r1 = () -> System.out.println("hello");
    
    List<Apple> list = new ArrayList<Apple>();
    
    list.sort(Comparator.comparing(Apple::getWeight));
    
    
  }

}

class Apple {
  int weight;
  
  public Apple(Integer i) {
    
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

 
}
