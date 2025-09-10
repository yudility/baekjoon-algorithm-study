package BOJ_1967;

import java.util.*;
import java.io.*;

public class 트리의지름_박유진 {

  static int n;
  static int answer = -1;
  static int findNode;
  static boolean[] visited;

  static class Edge {

    int to;
    int weight

    Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static void dfs(int now, List<List<Edge>> adj, int weight) {
    visited[now] = true;
    if (weight > answer) {
      findNode = now; // 가장 먼거리의 노드를 찾음
      answer = weight;
    }

    for (int i = 0; i < adj.get(now).size(); i++) {
      Edge edge = adj.get(now).get(i);
      if (!visited[edge.to]) {
        dfs(edge.to, adj, weight + edge.weight);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    List<List<Edge>> adj = new ArrayList<>();

    // 초기화
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 1; i <= n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int f = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      adj.get(f).add(new Edge(t, w));
      adj.get(t).add(new Edge(f, w));
    }

    visited = new boolean[n + 1];
    dfs(1, adj, 0); //아무 정점을 골라 먼거리의 노드를 찾는다.

    visited = new boolean[n + 1];
    dfs(findNode, adj, 0); //가장 먼 거리의 노드로부터 가장 먼 거리의 노드를 찾고 지름을 구한다.

    System.out.println(answer);
  }
}
