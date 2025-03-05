package BOJ_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 퇴사까지 남은 일수
        int[] T = new int[N + 1];   // 상담 소요 일수
        int[] P = new int[N + 1];   // 상담 이익
        int[] dp = new int[N + 2];  // i일까지 얻을 수 있는 최대 이익 저장

        // 상담 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 날짜별 상담 확인
        for (int i = 1; i <= N; i++) {
            // dp[i]와 dp[i-1] 중 큰 값 저장
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int nextDay = i + T[i]; // 상담 끝난 후 날짜 == 상담을 시작할 수 있는 날짜
            if (nextDay <= N + 1) { // 퇴사일을 넘지 않는 경우
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + P[i]);
            }
        }

        System.out.println(Math.max(dp[N], dp[N + 1]));
    }
}