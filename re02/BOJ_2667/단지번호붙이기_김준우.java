package BOJ_2667;

import java.util.*;
import java.io.*;

class 단지번호붙이기_김준우 {
  static int n;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    visited = new boolean[n][n];

    for(int i = 0; i < n; i++) {
      String line = br.readLine();
      for(int j = 0; j < n; j++) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }

    List<Integer> result = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          result.add(dfs(i, j));
        }
      }
    }

    Collections.sort(result);
    System.out.println(result.size());

    for(int s : result) {
      System.out.println(s);
    }


  }

  static int dfs(int x, int y) {
    visited[x][y] = true;
    int size = 1;

    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if (arr[nx][ny] == 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          size += dfs(nx, ny);
        }
      }
    }
    return size;
  }
}
