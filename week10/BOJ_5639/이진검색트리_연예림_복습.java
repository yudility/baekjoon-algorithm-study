package BOJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BinaryNode {
  int value;
  BinaryNode left;
  BinaryNode right;

  BinaryNode (int value, BinaryNode left, BinaryNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}

public class 이진검색트리_연예림_복습 {

  static BinaryNode root;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    root = null;

    // 입력 받기
    while(true) {
      String input = br.readLine();
      if (input == null || input.isBlank()) {
        break;
      }
      root = inputValue(root, Integer.parseInt(input));
    }

    visited(root);
    System.out.println(sb);
  }

  public static BinaryNode inputValue(BinaryNode current, int value) {
    if (current == null) {
      current = new BinaryNode(value, null, null);
    }

    if (value < current.value) {
      current.left = inputValue(current.left, value);
    } else if (value > current.value) {
      current.right =inputValue(current.right, value);
    }

    return current;
  }

  // 후위순회
  public static void visited(BinaryNode current) {
    if (current == null) {
      return;
    }
    visited(current.left);
    visited(current.right);
    sb.append(current.value).append("\n");
  }
}
