package code.topcoder;

import java.util.Arrays;

public class Ellys8Bit {

  static boolean[] getRe(int time, int diff) {
    System.out.println(diff);
    int len = 8 + time;
    boolean[] re = new boolean[len];
    Arrays.fill(re, true);

    int total = len - 1;
    while (total < diff) {
      
    }
    
    re[diff] = false;
    
    return re;
  }
  
  public static long getNumber(int N) {
    if (N ==1) {
      return 255;
    }
    int cnt = 1, fac = 8, time = 0, pre = 0; 
    
    while (cnt < N) {
      int sum = 1, num = 8;
      for (int i = 0; i < time+1; i++) {
        sum *= num--;
      }
      pre = cnt;
      cnt += sum;
      time++;
    }
    System.out.println(time + " " + cnt + " " + pre);
    boolean[] re = getRe(time, N - pre);
    System.out.println(Arrays.toString(re));
    
    return getResult(re);
  }
  
  static long getResult(boolean[] re){
    long result = 1;
    long fac = 1;
    
    for (int i = re.length - 1; i >= 0; i--){
      
      if(re[i]){
        result += fac;
      }
      fac *= 2;
    }    
    
    return result - 1;
  }
  public static void main(String[] args) {
    // 101111111
    System.out.println(getNumber(20));
  }

}

/** 
 * 
 * 
Problem Statement
    
"Pravetz" is a well-known brand of computers in Bulgaria, as the company used to manufacture all 8-bit computers in the country during the socialism. Suddenly, after a 20-year pause from being on the market, they released a modern, 64-bit laptop.  Elly recently bought such a laptop and now her mother is confused. How can an 8-bit computer be also 64-bit!? Elly, always being pain in the assembler, decided to joke with her by coming up with the following definition: "A 64-bit 8-bit number with at most 64 bits in its binary representation, which has exactly 8 bits set. (I.e., out of the 64 bits there are exactly eight 1s.)". By this definition, the first few such numbers are 255, 383, 447, 479, etc.  Elly told her mother that, in order to be in line with the new technologies, she has to be able to calculate these numbers by heart. To her surprise, she actually started doing so. Now the girl wants to check whether her calculations are correct.  Your task is simple: given an int N, return the N-th 64-bit 8-bit number.
Definition
    
Class:
Ellys8Bit
Method:
getNumber
Parameters:
int
Returns:
long
Method signature:
long getNumber(int N)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Constraints
-
N will be between 1 and 1,000,000,000, inclusive.
Examples
0)

    
1
Returns: 255
The first 64-bit 8-bit number is just the binary number 11111111, which is 255 in decimal.
1)

    
2
Returns: 383
The second 64-bit 8-bit number is 101111111, which is 383 in decimal.
2)

    
3
Returns: 447
The third 64-bit 8-bit number is 110111111, which is 447 in decimal.
3)

    
1000
Returns: 7032
The thousandth 64-bit 8-bit number is 1101101111000, which is 7032 in decimal.
4)

    
133742
Returns: 1087088

5)

    
537655880
Returns: 1125899983585796
Watch out for overflows!
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 * 
 * 
 * 
 * 
 * */ 
