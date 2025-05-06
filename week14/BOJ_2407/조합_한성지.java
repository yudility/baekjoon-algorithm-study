package BOJ_2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 조합_한성지 {

  // 큰 수를 다루기 위해 BigInteger 사용
  static BigInteger[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    dp = new BigInteger[n + 1][m + 1];

    System.out.println(solution(n, m));
  }

  static BigInteger solution(int n, int m) {
    if (n <= 0 || m < 0) {    // n, m이 0보다 작은 경우 조합이 성립하지 않으므로 0 반환
      return BigInteger.valueOf(0);
    }
    if (dp[n][m] != null) {   // null이 아닐 경우 이미 계산한 값이므로 해당 값 사용
      return dp[n][m];
    }
    if (n == m || m == 0) {   // nC0 == nCn == 1
      return dp[n][m] = BigInteger.valueOf(1);
    }

    // nCm == (n-1)C(m-1) + (n-1)Cm
    return dp[n][m] = solution(n - 1, m - 1).add(solution(n - 1, m));
  }
}