package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Ali {

  static boolean resolve(int[] A) {
    int len = A.length;
    int[] sum1 = new int[len];
    int[] sum2 = new int[len];
    sum1[0] = A[0];
    for (int i = 1; i < A.length; i++) {
      sum1[i] = A[i] + sum1[i - 1];
    }
    sum2[len - 1] = A[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      sum2[i] = A[i] + sum2[i + 1];
    }
    System.out.println(Arrays.toString(sum1));
    System.out.println(Arrays.toString(sum2));

    return judge(sum1, sum2, len);
  }

  static boolean judge(int[] sum1, int[] sum2, int len) {
    int i = 0, j = len - 1;
    while (i < j) {
      int sumBefore = sum1[i];
      int sumAfter = sum2[j];
      if (sumBefore < sumAfter) {
        i++;
      } else if (sumBefore > sumAfter) {
        j--;
      } else {
        if (juedge2(sum1, sum2, i + 1, j - 1, sumBefore)) {
          return true;
        }
        i++;
        j--;

      }
    }
    return false;
  }

  static boolean juedge2(int[] sum1, int[] sum2, int start, int end, int target) {
    for (int i = start + 1; i < end; i++) {
      int sumBefore = sum1[i - 1] - sum1[start];
      int sumAfter = sum2[i + 1] - sum2[end];
      if (sumBefore == sumAfter && target == sumAfter) {
        return true;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
    while (scanner.hasNextLine()) {
      String[] options = scanner.nextLine().split(";");
      if (options.length < 5) {
        break;
      }
      lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4],
          options[5]));
    }
    scanner.close();

    // wirte your code here
    List<String> result = calculateUnilateral(lineList);

    for (String str : result) {
      System.out.println(str);
    }
  }



  public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
    Map<String, LineNode> map = new HashMap<String, LineNode>();
    for (UnilateralLine unilateralLine : lineList) {
      LineNode a = map.get(unilateralLine.getSCen());
      if (a == null) {
        a = new LineNode(unilateralLine.getId(), unilateralLine.getSCen(),
            unilateralLine.getTType(), unilateralLine.getSPro());
      }
      LineNode b = map.get(unilateralLine.getECen());
      if (b == null) {
        b = new LineNode(unilateralLine.getId(), unilateralLine.getECen(),
            unilateralLine.getTType(), unilateralLine.getEPro());
      }
      a.next = b;
      map.put(unilateralLine.getSCen(), a);
      map.put(unilateralLine.getECen(), b);
    }
    List<String> result = new ArrayList<String>();
    rule1(map, result);
    rule2(map, result);
    rule3(map, result);
    return result;
  }

  static void rule1(Map<String, LineNode> map, List<String> result) {
    Set<String> set = new HashSet<String>();
    for (Map.Entry<String, LineNode> entry : map.entrySet()) {
      LineNode a = entry.getValue();
      LineNode b = a.getNext();
      if (a.getType() == b.getType() && b.getNext() == a) {
        set.add(a.getName());
        set.add(b.getName());
        result.add("rule1： " + a.getId() + "+" + b.getId());
      }
    }
    for (String s : set) {
      map.remove(s);
    }
  }

  static void rule2(Map<String, LineNode> map, List<String> result) {
    Set<String> set = new HashSet<String>();
    for (Map.Entry<String, LineNode> entry : map.entrySet()) {
      LineNode a = entry.getValue();
      LineNode b = a.getNext();
      if (a.getType() == b.getType()) {
        LineNode c = b.getNext();
        if (c.getType() == a.getType() && c.getNext() == a) {
          set.add(a.getName());
          set.add(b.getName());
          set.add(c.getName());
          result.add("rule2： " + a.getId() + "+" + b.getId() + "+" + c.getId());
        }
      }
    }
    for (String s : set) {
      map.remove(s);
    }
  }

  static void rule3(Map<String, LineNode> map, List<String> result) {
    Set<String> set = new HashSet<String>();
    for (Map.Entry<String, LineNode> entry : map.entrySet()) {
      LineNode a = entry.getValue();
      LineNode b = a.getNext();
      if (a.getType() == b.getType()) {
        LineNode c = b.getNext();
        if (c.getType() == a.getType() && c.getCity() == a.getCity()) {
          set.add(a.getName());
          set.add(b.getName());
          set.add(c.getName());
          result.add("rule3： " + a.getId() + "+" + b.getId() + "+" + c.getId());
        }
      }
    }
    for (String s : set) {
      map.remove(s);
    }
  }
}



class LineNode {
  String id;
  String name;
  LineNode next;
  String type;
  String City;

  public LineNode(String id, String name, String type, String city) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.City = city;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LineNode getNext() {
    return next;
  }

  public void setNext(LineNode next) {
    this.next = next;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCity() {
    return City;
  }

  public void setCity(String city) {
    City = city;
  }


}


class UnilateralLine {
  private String id;
  private String sCen;// 出发分拨
  private String sPro;// 出发省
  private String eCen;// 到达分拨
  private String ePro;// 到达省
  // 9.6m/17.5m
  private String tType;// 车型

  public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,
      String tType) {
    this.id = id;
    this.sCen = sCen;
    this.sPro = sPro;
    this.eCen = eCen;
    this.ePro = ePro;
    this.tType = tType;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSCen() {
    return sCen;
  }

  public void setSCen(String ePro) {
    this.ePro = ePro;
  }

  public String getSPro() {
    return sPro;
  }

  public void setSPro(String sPro) {
    this.sPro = sPro;
  }

  public String getECen() {
    return eCen;
  }

  public void setECen(String eCen) {
    this.eCen = eCen;
  }

  public String getEPro() {
    return ePro;
  }

  public void setEPro(String ePro) {
    this.ePro = ePro;
  }

  public String getTType() {
    return tType;
  }

  public void setTType(String tType) {
    this.tType = tType;
  }
}
