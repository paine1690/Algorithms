package interview.didi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    int k = sc.nextInt();

    String[] str = s.split(" ");
    int[] nums = new int[str.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.valueOf(str[i]);
    }
    
    int re = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > 0) {
        nums[i] += nums[i - 1];
      }
      re = Math.max(re, nums[i]);
    }
    System.out.println(re);
    
    
    
    
    //System.out.println(findKthLargest(nums, k));
  }

  private static int partition(int[] nums, int p, int r) {
    int x = nums[r];
    int i = p - 1;
    int temp;
    for (int j = p; j < r; j++) {
      if (nums[j] <= x) {
        i++;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
    temp = nums[i + 1];
    nums[i + 1] = nums[r];
    nums[r] = temp;
    return i + 1;
  }

  public static int findKthLargest(int[] nums, int k) {
    int len = nums.length;
    if (len == 1) {
      return nums[0];
    }
    int p = 0, r = len - 1, re = 0;
    while (p < r) {
      re = partition(nums, p, r);
      if (len - re == k) {
        return nums[re];
      } else if (len - re < k) {
        r = re - 1;
      } else {
        p = re + 1;
      }
    }
    return nums[r];
  }
  
  int findKth(int[] nums, int k, int start, int end) {
    
    
    
    
    return 0;
  }

}
