package BOJ_2839;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달_김준우 {
  static int N;
  static int[] dp;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    dp = new int[N + 1];
    Arrays.fill(dp, 5000);
    dp[0] = 0;

    for (int i = 3; i <= N; i++) {
      dp[i] = Math.min(dp[i], dp[i - 3] + 1);
      if (i >= 5) {
        dp[i] = Math.min(dp[i], dp[i - 5] + 1);
      }
    }

    System.out.println(dp[N] == 5000 ? - 1 : dp[N]);
  }
}
