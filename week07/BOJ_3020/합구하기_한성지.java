package BOJ_3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합구하기_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 수의 개수

        st = new StringTokenizer(br.readLine());
        long[] dp = new long[N + 1];

        // 누적합 저장
        for (int i = 0; i < N; i++) {
            dp[i + 1] = dp[i] + Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            // 구간
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // b까지 더한 값에서 a 미만까지 더한 값을 뺌
            long sum = dp[b] - dp[a - 1];


            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}