package BOJ_21278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 호석이두마리치킨_연예림 {
  static List<List<Integer>> graph;
  static int[][] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // Tree
    graph = new ArrayList<>();
    for (int i = 0; i < N+1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    // 방문 기록
    check = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      visit(i);
    }

    // 두 값을 뽑아 비교하기
    int one = 0;
    int two = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= N-1; i++) {
      for (int j = i + 1; j <= N; j++) {
        if (i == j) {
          continue;
        }
        int sum = 0;
        for (int k = 1; k <= N; k++) {
          sum += Math.min(check[i][k], check[j][k]);
        }
        if (sum < min) {
          min = sum;
          one = i;
          two = j;
        }
      }
    }

    System.out.println(one + " " + two + " " + min);
  }

  public static void visit(int start) {

    Deque<Integer> deque = new LinkedList<>();
    deque.offerLast(start);
    check[start][start] = 0;

    while (!deque.isEmpty()) {
      int n = deque.pollLast();

      for (int k : graph.get(n)) {
        if ((check[start][k] == 0 && start != k) || check[start][k] > check[start][n] + 2) { // 순환이 있는 경우 고려
          check[start][k] = check[start][n] + 2; // 이전값의 + 2를 해서 넣어주기
          deque.add(k);
        }
      }
    }
  }
}
