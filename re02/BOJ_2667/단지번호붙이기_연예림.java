package BOJ_2667;

import java.util.*;
import java.io.*;

public class 단지번호붙이기_연예림 {
  // 데이터
  public static int N;
  public static int[][] graph;
  public static boolean[][] visited;

  // result
  public static List<Integer> houses;

  // 사면
  public static int[] dx = {0, 0, 1, -1};
  public static int[] dy = {1, -1, 0, 0};


  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력 N
    N = Integer.parseInt(br.readLine());
    graph = new int[N][N];
    visited = new boolean[N][N];
    houses = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] arr = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        graph[i][j] = Integer.parseInt(arr[j]);
      }
    }

    // 탐색
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (graph[i][j] == 1 && !visited[i][j]) {
          houses.add(bfs(i,j));
        }
      }
    }


    // result (연결요소 수, 각 개수)
    System.out.println(houses.size());
    houses.stream().sorted().forEach(cnt -> System.out.println(cnt));

  }

  public static int bfs(int n, int m) {


    Deque<int[]> queue = new LinkedList<>();
    queue.add(new int[]{n,m});
    visited[n][m] = true;
    int houseCnt = 1;

    while(!queue.isEmpty()) {

      int[] node = queue.poll();
      int x = node[0];
      int y = node[1];

      // 사면 확인
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 범위 확인
        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
          if (graph[nx][ny] == 1 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            houseCnt += 1;
            queue.add(new int[]{nx, ny});
          }

        }
      }
    }

    return houseCnt;
  }
}
