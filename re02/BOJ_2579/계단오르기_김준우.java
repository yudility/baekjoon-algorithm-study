package BOJ_2579;

import java.util.*;
import java.lang.*;
import java.io.*;

class 계단오르기_김준우 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n + 1];

    for(int i = 0; i < n; i++) {
      arr[i + 1] = sc.nextInt();
    }

    int[] dp = new int[n + 1];
    if (n >= 1) dp[1] = arr[1];
    if (n >= 2) dp[2] = arr[1] + arr[2];

    for(int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
    }

    System.out.println(dp[n]);
  }
}
