package codeMM;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

  
  
  
  static void No5(int n) {
    int L = (int) Math.ceil(Math.sqrt(n) / 2);    
    int[] nums = new int[L + 1];
    nums[0] = 1;
    nums[1] = 1;
    
    int j = 2;
    for (int i = 2; i < nums.length; i++) {
      nums[i] = nums[i - 1] + j;
      j *= 2;
    }
    System.out.println(Arrays.toString(nums));
    System.out.println(L);
    for(int i = 1; i < nums.length - 1; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println(nums[nums.length - 1]);
    if(nums[nums.length - 1] > n) {
      System.out.println("dada");
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    No5(n);
  }

}
