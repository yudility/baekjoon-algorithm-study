package BOJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리_이유빈 {

  static class Node {
    int num;
    Node left, right;

    Node(int num) {
      this.num = num;
    }

    Node(int num, Node left, Node right) {
      this.num = num;
      this.left = left;
      this.right = right;
    }

    void insert(int n) {
      if (n < this.num) {
        if (this.left == null) {
          this.left = new Node(n);
        } else this.left.insert(n);
      } else {
        if (this.right == null) {
          this.right = new Node(n);
        } else this.right.insert(n);
      }
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Node root = new Node(Integer.parseInt(br.readLine()));
    String input;
    while (true) {
      input = br.readLine();
      if (input == null || input.isEmpty()) break;
      root.insert(Integer.parseInt(input));
    }

    postOrder(root);
  }

  static void postOrder(Node root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.num);
  }
}
