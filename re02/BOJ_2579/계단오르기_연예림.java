package BOJ_2579;

import java.io.*;

public class 계단오르기_연예림 {
  public static int[] dp;
  public static int[] points;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 계단 수
    int totalCount = Integer.parseInt(br.readLine());
    points = new int[totalCount+1];
    dp = new int[totalCount+1];

    // 계단 점수 입력
    for (int i = 1; i <= totalCount; i++) {
      points[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = 0;
    dp[1] = points[1];

    if (totalCount >= 2) {
      dp[2] = points[1] + points[2];
    }

    // 연속 3번 이상 한 계단씩 올라갈 수 없다.
    // i 번째 계단에 올라가기 위해서는
    // 1. i-2 에서 올라오거나
    // 2. i-3 에서 i-1를 밟고 i에 올라와야한다.
    // * i-2 -> i-1 -> i 로 올라오는 경우를 제외하는 것이다.
    for (int i = 3; i <= totalCount; i++) {
      dp[i] = Math.max(dp[i-2], dp[i-3] + points[i-1]) + points[i];
    }

    System.out.println(dp[totalCount]);
  }
}
