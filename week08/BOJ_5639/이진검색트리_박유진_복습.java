package BOJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리_박유진_복습 {


  static class Node_binary_search {
    int value;
    Node_binary_search leftChild;
    Node_binary_search rightChild;

    public Node_binary_search(int value) {
      this.value = value;
      Node_binary_search leftChild = null;
      Node_binary_search rightChild = null;
    }

    public void insert(int value) {
      if(value < this.value ) {
        if(this.leftChild == null) {
          this.leftChild = new Node_binary_search(value);
        }else{
          this.leftChild.insert(value);
        }
      }
      else if(value > this.value ) {
        if(this.rightChild == null) {
          this.rightChild = new Node_binary_search(value);
        }else{
          this.rightChild.insert(value);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int root_value = Integer.parseInt(br.readLine());
    Node_binary_search root = new Node_binary_search(root_value);

    while (true) {
      String s = br.readLine();
      if( s== null || s.isEmpty()) break;

      int n = Integer.parseInt(s);
      root.insert(n);
    }

    postOrder(root, sb);

    System.out.println(sb);

  }

  public static void postOrder(Node_binary_search root, StringBuilder sb) {
    if(root == null) return;

    postOrder(root.leftChild, sb);
    postOrder(root.rightChild, sb);

    sb.append(root.value).append("\n");
  }
}
