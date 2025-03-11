package BOJ_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5_연예림 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 배열 입력
    int[][] matrix = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 구간합 구하기
    int[][] sums = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        // 위쪽
        if (i-1 > 0) {
          sums[i][j] += sums[i-1][j];
        }
        // 왼쪽
        if (j-1 > 0) {
          sums[i][j] += sums[i][j-1];
        }
        // 왼쪽 대각선 상단
        if (i-1 > 0 && j-1 > 0) {
          sums[i][j] -= sums[i-1][j-1];
        }
        // 현재값
        sums[i][j] += matrix[i][j];
      }
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int a1 = Integer.parseInt(st.nextToken());
      int a2 = Integer.parseInt(st.nextToken());
      int b1 = Integer.parseInt(st.nextToken());
      int b2 = Integer.parseInt(st.nextToken());

      int result = sums[b1][b2] - sums[a1-1][b2] - sums[b1][a2-1] + sums[a1-1][a2-1];
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }
}
