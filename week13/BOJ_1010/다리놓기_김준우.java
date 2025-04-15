package BOJ_1010;

import java.util.Scanner;

public class 다리놓기_김준우 {

  static final int MAX = 30;
  static int[][] dp = new int[MAX + 1][MAX + 1];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i <= MAX; i++) {
      dp[i][0] = 1;
      dp[i][i] = 1;
      for (int j = 1; j < i; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    }

    while (n-- > 0) {
      int N = sc.nextInt();
      int M = sc.nextInt();

      System.out.println(dp[M][N]);
    }
  }
}