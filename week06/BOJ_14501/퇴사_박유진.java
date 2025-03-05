package BOJ_14501;

import java.util.*;
import java.io.*;

public class 퇴사_박유진 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    int[] T = new int[n];
    int[] P = new int[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[n+1];

    for(int i=0; i<n; i++){
      if(i+T[i] <= n){
        dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]); //현재 값과, 더한 값 중 큰 쪽을 넣는다.
      }
      dp[i+1] = Math.max(dp[i+1], dp[i]); //다음 dp 는 현재 누적값과 다음 누적값을 비교하여 넣는다. (오늘 일한걸 다음날 누적 시키기 위함)
    }
    System.out.println(dp[n]);
  }
}
