package BOJ_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());   // 표 크기
        int M = Integer.parseInt(st.nextToken());   // 합 구할 횟수

        int[][] table = new int[N + 1][N + 1];  // 표

        // 표 채우기
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 표의 각 줄 누적합 계산
        long[][] dp = new long[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = dp[i][j - 1] + table[i][j];
            }
        }

        // 계산
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            // 각 좌표 저장(x=행, y=열)
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long sum = 0;
            for (int i = x1; i <= x2; i++) {
                sum += dp[i][y2] - dp[i][y1-1];     // 가로줄의 구간합을 구하여 sum에 합함
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}