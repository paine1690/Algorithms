package code.hihocoder_ms;

import java.util.Scanner;

public class Main {

  static int num, num1, num2;  
  static int re;
  
  
  static void dfs(int[] nums, int index, int pre){
    if (index == nums.length) {
      if (num1 == 0 && num2 == 0 && pre == 0){
        re++;
      }
      return ;
    }
    
    int cur = nums[index] + pre;
    
    if (cur == (num + 1) && num2 > 0) {
      num2--;
      dfs(nums, index + 1, 0);
      num2++;
    }
    if (cur == num && num1 > 0) {
      num1--;
      dfs(nums, index + 1, 0);
      num1++;      
    }
    dfs(nums, index + 1, cur);
    
  }
  
  public static void main(String[] args) {
    re = 0;
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i ++) {
      int num = sc.nextInt();
      sum += num;
      nums[i] = num;
    }
    num = sum / 3;
    num2 = sum % 3;
    num1 = 3 - num2;
    dfs(nums, 0, 0);
    System.out.println(re);
  }

}
