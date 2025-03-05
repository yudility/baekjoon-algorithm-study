package BOJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class NodeY {
  int value;
  NodeY left;
  NodeY right;

  public NodeY(int value, NodeY left, NodeY right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public void setLeft(NodeY left) {
    this.left = left;
  }

  public void setRight(NodeY right) {
    this.right = right;
  }
}

public class 이진검색트리_연예림 {
  static Queue<Integer> queue;
  static StringBuilder sb;
  static int start;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    queue = new LinkedList<>();
    while (true) {
      String input = br.readLine();
      if (input == null || input.isBlank()) {
        break;
      }
      queue.offer(Integer.parseInt(input));
    }

    start = queue.poll();
    NodeY root = new NodeY(start, null, null);

    while(!queue.isEmpty()) {
      createNode(root, queue.poll());
    }

    sb = new StringBuilder();
    visit(root);

    System.out.println(sb);

  }

  // 방문
  public static void visit(NodeY node) {
    if (node == null) {
      return;
    }
    visit(node.left);
    visit(node.right);
    sb.append(node.value).append("\n");
  }

  public static NodeY createNode(NodeY node, int input) {
    // 노드가 없으면 추가
    if (node == null) {
      return new NodeY(input, null, null);
    }

    // 현재 노드값보다 작으면 왼쪽 노드와 함께 넘김
    if (node.value > input) {
      node.left = createNode(node.left, input);
    } else {
      node.right = createNode(node.right, input);
    }
    return node;
  }

}
