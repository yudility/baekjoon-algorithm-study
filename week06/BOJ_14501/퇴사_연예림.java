package BOJ_14501;
//https://dinist.tistory.com/30
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_연예림 {
  //15분

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    int max = 20;
    int[] times = new int[max];
    int[] pays = new int[max];
    int[] dp = new int[max];

    //입력
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      times[i] = Integer.parseInt(st.nextToken());
      pays[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = N; i > 0; i--) {
      if (times[i] > N - i + 1) {
        dp[i] = dp[i+1];
      } else {
        dp[i] = Math.max(pays[i] + dp[i+times[i]] , dp[i+1]);
        // 현재 날짜의 pay + 이후 남은 날짜의 최대 페이 vs 이전 날짜의 최대페이
      }
    }

    System.out.println(dp[1]);
  }
}
