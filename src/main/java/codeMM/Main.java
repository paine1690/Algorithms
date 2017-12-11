package codeMM;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  
  
  

  
  static double re;
  static int cnt;
  static Stack<Integer> stack;
  
  
  static void dfs(int[] nums, int index) {
    if (index == nums.length) {
      re += stack.size();
      cnt++;
      return;
    }
    nums[index] = 0;
    stack.push(0);
    dfs(nums, index + 1);
    if (!stack.isEmpty()) {
      stack.pop();
    }
    //stack.pop();    
    
    nums[index] = 1;
    if (!stack.isEmpty() && stack.peek() == 0) {
      stack.pop();
      dfs(nums, index + 1);
      stack.push(0);
    } else {
      stack.push(1);
      dfs(nums, index + 1);   
      if (!stack.isEmpty()) {
        stack.pop();
      }
    }     
    
  }
  
  
  
  
  static void No1(int n) {
    int[] nums = new int[n];
    re = 0;
    cnt = 0;
    int index = 0;
    stack = new Stack<Integer>();
    dfs(nums, index);
    
    //re /= cnt;
    
    
    System.out.println(String.format("%.3f", re));
  }
  
  public static void main(String[] args) {
    for (int i = 1; i < 10; i++) {
      No1(i);
    }
    
  }

}
