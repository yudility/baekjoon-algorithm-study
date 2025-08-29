package BOJ_1012;

import java.util.*;
import java.lang.*;

public class 유기농배추_김준우 {

  static int T,M,N,K;
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    T = sc.nextInt();
    for(int i = 0; i < T; i++) {
      int result = 0;
      M = sc.nextInt();
      N = sc.nextInt();
      K = sc.nextInt();

      graph = new int[M][N];
      visited = new boolean[M][N];
      for(int j = 0; j < K; j++) {
        int x = sc.nextInt();
        int y = sc.nextInt();

        graph[x][y] = 1;
      }

      for(int a = 0; a < M; a++) {
        for(int b = 0; b < N; b++) {
          if (graph[a][b] == 1 && !visited[a][b]) {
            dfs(a, b);
            result++;
          }
        }
      }

      System.out.println(result);

    }

  }

  static void dfs(int x, int y) {
    visited[x][y] = true;

    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
        if(!visited[nx][ny] && graph[nx][ny] == 1) {
          dfs(nx, ny);
        }
      }
    }
  }
}