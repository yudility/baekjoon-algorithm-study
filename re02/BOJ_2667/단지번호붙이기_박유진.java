package BOJ_2667;

import java.util.*;
import java.io.*;

public class 단지번호붙이기_박유진 {

  static int count;
  static int n;
  static int total;
  static int[][] map = new int[26][26];
  static boolean[][] visited = new boolean[26][26];
  static int[] dy = {1, 0, -1, 0};
  static int[] dx = {0, 1, 0, -1};

  static void dfs(int y, int x) {
    visited[y][x] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (ny < 0 || nx < 0 || nx >= n || ny >= n) {
        continue;
      }
      if (visited[ny][nx] || map[ny][nx] != 1) {
        continue;
      }
      dfs(ny, nx);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String lines = br.readLine();
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(lines.substring(j, j + 1));
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          count = 0;
          total++;
          dfs(i, j);
          result.add(count);
        }
      }
    }

    Collections.sort(result);

    bw.write(total + "\n");

    for(int i = 0; i < result.size(); i++) {
      bw.write(result.get(i) + "\n");
    }

    bw.flush();
    bw.close();

  }
}

