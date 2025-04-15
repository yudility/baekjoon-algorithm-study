package BOJ_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1010
public class 다리놓기_한성지 {

  static int T;   // 테스트 케이스 개수
  static int[][] dp;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // 서쪽 사이트 개수
      int M = Integer.parseInt(st.nextToken()); // 동쪽 사이트 개수
      dp = new int[M + 1][N + 1];

      // mCn
      sb.append(bc(M, N)).append("\n");
    }

    System.out.println(sb);
  }

  // mCn (조합)
  static int bc(int m, int n) {
    if (dp[m][n] > 0) {   // 이미 계산했던 경우 해당 값 반환
      return dp[m][n];
    }
    if (n == 0 || n == m) {   // mC0 == mCm == 1
      return dp[m][n] = 1;
    }

    // mCn == m-1Cn-1 + m-1Cn
    return dp[m][n] = bc(m - 1, n - 1) + bc(m - 1, n);
  }
}