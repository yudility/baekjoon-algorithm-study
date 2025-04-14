package BOJ_9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node {
  int level;
  Node right;
  Node left;

  public Node(int level, Node left, Node right) {
    this.level = level;
    this.left = left;
    this.right = right;
  }
}

public class 완전이진트리_연예림 {
  static int k; // 레벨
  static double maxCnt; // 최대 노드 개수
  static List<List<String>> nodeLevel; // 레벨별 노드 기록
  static String[] input; // 입력 수열

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    k = Integer.parseInt(br.readLine());
    input = br.readLine().split(" ");

    // 레벨별 노드 기록용
    nodeLevel = new ArrayList<>();
    for (int i = 0; i <= k + 1; i++) {
      nodeLevel.add(new ArrayList<>());
    }

    // 필요한만큼만 노드 생성
    maxCnt = input.length;
    int level = 1; // 레벨 기록용
    Node root = new Node(level++, returnNode(level, 2), returnNode(level, 3));

    // 방문하며 노드별 레벨 기록
    visit(root);

    // 출력
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < nodeLevel.size(); i++) {
      nodeLevel.get(i).forEach(n-> sb.append(n).append(" "));
      sb.append("\n");
    }
    System.out.println(sb);
  }

  // 탐색
  static int i = 0;
  public static void visit(Node node) {
    if (node == null) {
      return;
    }
    visit(node.left);
    nodeLevel.get(node.level).add(input[i++]); // 레벨 기록
    visit(node.right);
  }

  // 노드 생성
  public static Node returnNode(int level, int cnt) {
    if (cnt > maxCnt || level > k) { // 필요한 노드 수 이상 생성 불가
      return null;
    }
    return new Node(level++, returnNode(level, cnt+1), returnNode(level, cnt+2));
  }
}
