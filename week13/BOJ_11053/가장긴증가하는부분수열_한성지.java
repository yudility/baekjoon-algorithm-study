package BOJ_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_한성지 {

  static int N;   // 수열 크기
  static int[] A; // 수열
  static int[] dp;  // 수열의 해당 요소까지 만들 수 있는 증가하는 부분수열의 최대 길이

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    A = new int[N];
    dp = new int[N];

    // 배열 채우기
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      solution(i);
    }

    // 최대값 구하기
    int max = dp[0];
    for (int i = 1; i < N; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }

  static int solution(int n) {
    if (dp[n] == 0) { // 계산한 적 없는 값일 때
      dp[n] = 1;  // 1로 초기화 (부분수열의 가장 작은 크기는 1)

      for (int i = n - 1; i >= 0; i--) {  // n-1부터 0까지 확인
        if (A[i] < A[n]) {  // A[n] 이전 요소 중 더 작은 값이 있는 경우
          dp[n] = Math.max(dp[n], solution(i) + 1); // dp[n]은 dp[n]과 재귀+1 중 더 작은 값
        }
      }
    }

    return dp[n];
  }
}