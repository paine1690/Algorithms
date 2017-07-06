package code.codeM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

  static Map<Integer, Set<Integer>> Fset;
  
  
  
  static Map<Integer, LinkedList<Integer>> getMap(int[] father) {
    Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
    LinkedList<Integer> temp = new LinkedList<Integer>();
    temp.addLast(1);
    map.put(1, temp);
    
    for (int i = 2; i < father.length; i++) {
      int f = father[i];
      if (map.containsKey(f)) {
        LinkedList<Integer> list = map.remove(f);
        list.addLast(i);
        map.put(i, list);        
      } else {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(f);
        list.addLast(i);
        map.put(i, list);
      }
      Set<Integer> set = Fset.get(f);
      if (set == null) {
        set = new HashSet<Integer>();
        
      } 
      set.add(i);
      Fset.put(f, set);
    }
    return map;
  }
  
  static boolean isAll(boolean[] black) {
    for (int i = 0; i < black.length; i++) {
      if(black[i] == false) {
        return false;
      }
    }
    
    return true;
  }
  
  static boolean isLeaf(int i) {
    if (!Fset.containsKey(i) || Fset.get(i).isEmpty()) {
      return true;
    }    
    return false;
  }
  static void No1(int[] father, int[] k) {
    Fset = new HashMap<Integer, Set<Integer>>();
    Map<Integer, LinkedList<Integer>> map = getMap(father);
    int cnt = 0;
    boolean[] black = new boolean[father.length];
    black[0] = true;
    while(!isAll(black) || map.isEmpty()) {
      for (Map.Entry<Integer,LinkedList<Integer>> entry : map.entrySet()) {
        int index = entry.getKey();
        if(isLeaf(index)) {
          int num = k[index];
          LinkedList<Integer> list = entry.getValue();
          for (int i = 0; i < num; i++) {
            if (list.isEmpty()) {
              map.remove(index);
              break;
            }
            int last = list.removeLast();
            black[last] = true;
            if (list.isEmpty()) {
              map.remove(index);
              break;
            }
            Set<Integer> set = Fset.get(list.getLast());
            if (set != null && set.contains(last)) {
              set.remove(last);
            }           
          }
          break;
        }
      }
      cnt++;
    }
    
    System.out.println(cnt);
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] father = new int[n+1];
    for (int i = 2; i <= n; i++) {
      father[i] = sc.nextInt();
    }
    int[] k = new int[n+1];
    for (int i = 1; i <= n; i++) {
      k[i] = sc.nextInt();
    }
    No1(father, k);
  }

}
