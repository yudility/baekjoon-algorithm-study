package BOJ_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기_이유빈 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] graph = new int[n][n];

    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j=0; j<n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 2차원 누적합 계산
    int[][] prefix = new int[n+1][n+1];

    for (int y=0; y<n; y++) {
      for (int x=0; x<n; x++) {
        prefix[y+1][x+1] = prefix[y][x+1]+prefix[y+1][x] - prefix[y][x] + graph[y][x];
      }
    }

    for (int k=0; k<m; k++) {
      st = new StringTokenizer(br.readLine());
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      int answer = prefix[y2][x2] - prefix[y2][x1-1] - prefix[y1-1][x2] + prefix[y1-1][x1-1];
      System.out.println(answer);
    }
  }

}

