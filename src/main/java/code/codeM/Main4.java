package code.codeM;

import java.util.Scanner;

public class Main4 {
  
  private static int getKSum(int num, int k, int b) {
    int re = 0;
    while (num != 0) {
      re += num % k;
      re %= b;
      num = (num - num % k) / k;
    }
    return re;
  }
  
  private static String jugde(int a, int b, int c, int k) {
    for (int n = 1; n < 1000; n++) {
      int an = a * n;
      int sum = getKSum(an, k, b);
      if (sum % b == c) {
        return "Yes";
       
      }
    }
    return "No";
  }
   
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    String[] re = new String[T];
    for (int  i = 0; i < T; i++) {
      int  a = sc.nextInt();
      int  b = sc.nextInt();
      int  c = sc.nextInt();
      int  k = sc.nextInt();
      re[i] = jugde(a, b, c, k);
    }
    for (int i = 0; i < re.length; i++) {
      System.out.println(re[i]);
    }
  }

}
