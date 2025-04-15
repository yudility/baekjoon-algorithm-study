package BOJ_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_박유진 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i< n; i++ ){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n];

    for(int i = 0; i < n; i++) {
      dp[i] = 1;

      // 0 ~ i 이전 원소들 탐색
      for(int j = 0; j < i; j++) {

        // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
        if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;  // j번째 원소의 +1 값이 i번째 dp가 된다.
        }
      }
    }
    // 최댓값(최대 길이) 탐색
    int max = -1;
    for(int i = 0; i < n; i++) {
      max = Math.max(dp[i], max);
    }
    System.out.println(max);
  }
}
