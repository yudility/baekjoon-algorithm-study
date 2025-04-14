package BOJ_21278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 호석이두마리치킨_연예림_복습 {

  static List<List<Integer>> graph;
  static int[][] shortest;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 입력
    int nodeCount = Integer.parseInt(st.nextToken());
    int edgeCount = Integer.parseInt(st.nextToken());

    // n -> n + 1 의 배열 생성
    graph = new ArrayList<>();
    for (int i = 0; i <= nodeCount; i++) {
      graph.add(new ArrayList<>());
    }

    // 그래프 입력
    for (int i = 0; i < edgeCount; i++) {
      st = new StringTokenizer(br.readLine());
      int nodeA = Integer.parseInt(st.nextToken());
      int nodeB = Integer.parseInt(st.nextToken());
      graph.get(nodeA).add(nodeB);
      graph.get(nodeB).add(nodeA);
    }

    // 최단 시간을 기록하는 2차원 배열
    shortest = new int[nodeCount + 1][nodeCount + 1];

    // 기록 a -> 모든 노드들에 대한 시간을 기록 (왕복 시간이므로 기본 * 2) -> 결과만 곱해도 될 것 같다.
    for (int i = 1; i <= nodeCount; i++) {
      visited(i);
    }

    // 최단시간 확인
    int result = Integer.MAX_VALUE; // 초기값을 테스트 값을 기준으로 하여 틀림..ㅎㅎ
    int n1 = 0;
    int n2 = 0;

    for (int i = 1; i < nodeCount; i++) {
      for (int j = i+1; j <= nodeCount; j++) {

        if (i == j) {
          continue;
        }

        int sum = 0;

        for (int n = 1; n <= nodeCount; n++) {
          sum += Math.min(shortest[n][i], shortest[n][j]);
        }

        if (sum < result) {
          result = sum;
          n1 = i;
          n2 = j;
        }
      }
    }

    System.out.println(n1 + " " + n2 + " " + result);

  }

  public static void visited(int start) {

    Deque<Integer> deque = new LinkedList<>();
    deque.add(start);

    while (!deque.isEmpty()) {
      // 만약 현재 노드가 연결된 노드가 있다면 방문 체크
      int current = deque.poll();

      // 현재 노드까지의 코스트 값 + 1 이 기존 노드 값  != 현재 노드 값 + 2 보다 작다면 다시 방문하여 체크
      for (int next : graph.get(current)) {

        if (next != start && (shortest[start][next] == 0
            || shortest[start][current] + 2 < shortest[start][next])) {

          shortest[start][next] = shortest[start][current] + 2;
          deque.add(next);
        }

      }
    }
  }

}
