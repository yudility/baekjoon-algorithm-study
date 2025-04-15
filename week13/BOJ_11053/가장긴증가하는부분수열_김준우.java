package BOJ_11053;

import java.util.Scanner;

public class 가장긴증가하는부분수열_김준우 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    int[] dp = new int[n];
    int count = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      count = Math.max(count, dp[i]);
    }
    System.out.println(count);
  }
}
