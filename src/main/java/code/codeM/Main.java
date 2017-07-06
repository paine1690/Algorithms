package code.codeM;

import java.util.Scanner;

public class Main {


  
  
  static char[] arr = new char[]{
      '0',
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9',
      'A',
      'B',
      'C',
      'D',
      'E',
      'F',
      
      };
  
  private static StringBuilder getNum(int num, int k) {
    StringBuilder re = new StringBuilder();
    while (num != 0) {
      re.append(arr[num % k]);
      num = (num - num % k) / k;
    }
    return re.reverse();
  }
  
  private static String getK(int n, int k) {
    StringBuilder re = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      re.append(getNum(i, k));
    }
    return re.toString();
  }
  
  static boolean subString(String T, int[] next, String P) {
    int j=0;
    int m=P.length();
    for(int i=0; i<T.length(); i++){
        while(j>0&&T.charAt(i)!=P.charAt(j)){
            j=next[j];
        }
        if(T.charAt(i)==P.charAt(j)){
            j++;
        }
        if(j==m){
            return true;
        }
    }
    return false;
  }
  
  
  private static int[] getNext(String P){
    int m=P.length();
    int[] next=new int[m+1];
    next[0]=next[1]=0;
    int j=0;
    
    for(int i=1; i<m; i++){
        while(j>0&&P.charAt(i)!=P.charAt(j)){
            j=next[j];
        }
        if(P.charAt(i)==P.charAt(j)){
            j++;
        }
        next[i+1]=j;
    }
    return next;
}
  
  
  
  private static void NO5(String t, int n) {
    int[] next=getNext(t);
    for (int i = 2; i <= 16; i++) {
      String s = getK(n, i);
      if (subString(s, next, t)) {
        System.out.println("yes");
        return;
      }
    }
    System.out.println("no");
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String t = sc.nextLine();
    NO5(t, n);
    
    
    
    

    

  }

}
