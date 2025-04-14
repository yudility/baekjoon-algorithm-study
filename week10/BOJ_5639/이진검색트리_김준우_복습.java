package BOJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리_김준우_복습 {

  static class Node {

    int value;
    Node left, right;

    Node(int value) {
      this.value = value;
      left = right = null;
    }

    void insert(int num) {
      if (num < value) {
        if (this.left == null) {
          this.left = new Node(num);
        } else {
          this.left.insert(num);
        }
      } else {
        if (this.right == null) {
          this.right = new Node(num);
        } else {
          this.right.insert(num);
        }
      }
    }
  }

  static void postorder(Node node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    Node root = null;

    while ((input = br.readLine()) != null && !input.isEmpty()) {
      int num = Integer.parseInt(input);
      if (root == null) root = new Node(num);
      else root.insert(num);
    }

    postorder(root);
  }
}
