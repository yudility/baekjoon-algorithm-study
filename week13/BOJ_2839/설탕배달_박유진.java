package BOJ_2839;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달_박유진 {
  /*public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int answer = 0;
    while (n > 0) {
      if (n % 5 == 0) {
        answer += (n / 5);
        n = 0;
        break;
      }
      n -= 3;
      answer++;
    }
    if (n <= -1) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }

  }*/
  // DP 풀이

  static int[] dp;
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    dp = new int[n+5];

    Arrays.fill(dp, 5000/3 + 1); // 최소값을 구하는 문제이므로 최대값으로 초기화
    dp[3]=dp[5]=1; // 각 경우 봉지 하나만 써도 됨

    for(int i = 6; i <= n+1; i++) dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;

    System.out.println(String.valueOf(dp[n] >= 5000/3 + 1 ? -1 : dp[n]));

  }
}



