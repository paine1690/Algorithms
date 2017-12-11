package interview.toutiao;

public class Main {
  public static void main (String[] args) {
  Node head = new Node(6);
  for (int i = 5; i >= 1; i--) {
      Node newNode = new Node(i);
      newNode.next = head;
      head = newNode;
  }
  Set set = new Set();
  set.setHead(head);
  System.out.println("11");
  System.out.println(set.remove(1));
}
}


class Node {
int data;
Node next;

public Node(int data) {
  this.data = data;
}


}
class Set {
private Node head;
public Set() {
  head = null;
}


public boolean remove (int d){
  if (head.data == d) {
      head = head.next;
      return true;
  }
  Node node = head;        
  while(node.next != null) {
      if (node.next.data == d) {
          node.next = node.next.next;
          return true;
      }
      node = node.next;
  }
  return false;
}

public void setHead(Node head) {
  this.head = head;
}

public Set union(Set other){
  Node result = new Node(-1);
  Node node = result;
  Node p = this.head, q = other.head;
  while(p != null && q != null) {
      int min = Math.min(p.data, q.data);
      Node newNode = new Node(min);
      node.next = newNode;
      node = node.next;
      if (min == p.data) {
          p = p.next;
      }
      if (min == q.data) {
          q = q.next;
      }
  }
  
  if (p == null) {
      p = q;
  }
  
  while(p != null) {
      Node newNode = new Node(p.data);
      node.next = newNode;
      node=node.next;
  }
  
  Set resultSet = new Set();
  resultSet.setHead(result.next);
  
  return resultSet;
}


}






