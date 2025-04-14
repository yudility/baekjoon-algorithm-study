package BOJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리_한성지_복습 {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 처음 들어온 숫자는 항상 루트
    Node root = new Node(Integer.parseInt(br.readLine()));

    String input;
    while (true) {
      input = br.readLine();
      if (input == null || input.isBlank()) {
        break;
      }
      root.insert(Integer.parseInt(input));
    }
    postOrder(root);
    System.out.println(sb);
  }

  // 트리 노드 클래스
  static class Node {

    int num;
    Node left;
    Node right;

    public Node(int num) {
      this.num = num;
    }

    // 트리 만들기
    void insert(int n) {
      if (num > n) {
        if (this.left == null) {
          this.left = new Node(n);
        } else {
          this.left.insert(n);
        }
      } else {
        if (this.right == null) {
          this.right = new Node(n);
        } else {
          this.right.insert(n);
        }
      }
    }
  }

  // 후위 순회
  static void postOrder(Node node) {
    if (node == null) {
      return;
    }

    postOrder(node.left);
    postOrder(node.right);
    sb.append(node.num).append("\n");
  }
}