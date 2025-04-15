package BOJ_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2156
public class 포도주시식_한성지 {

  static int n; // 포도주 잔의 개수
  static int[] wine;  // 포도주 배열
  static Integer[] dp;  // i번째까지 마셨을 때 최대값 저장

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    wine = new int[n + 1];
    dp = new Integer[n + 1];

    for (int i = 1; i <= n; i++) {
      wine[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = 0;
    dp[1] = wine[1];
    if (n > 1) {  // n이 1일 수 있으므로 조건 추가
      dp[2] = wine[1] + wine[2];
    }

    System.out.println(solution(n));
  }

  static int solution(int n) {
    if (dp[n] == null) {
      // 1. n-2번째까지 + n번째 마신 경우
      // 2. n-3번째까지 + n-1번째 + n번째 마신 경우
      // 3. n-1번째까지 마신 경우 (n번째 마시지 않음)
      dp[n] = Math.max(Math.max(solution(n - 2), solution(n - 3) + wine[n - 1]) + wine[n],
          solution(n - 1));
    }

    return dp[n];
  }
}