package BOJ_21318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피아노체조_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 악보 개수

        int[] sheet = new int[N + 1];     // 1~N번 악보 난이도 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sheet[i] = Integer.parseInt(st.nextToken());
        }

        // 실수 횟수 누적합
        int[] dp = new int[N + 1];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + (sheet[i] > sheet[i + 1] ? 1 : 0);
        }

        int Q = Integer.parseInt(br.readLine());    // 질문 개수

        // 구간합
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // y번째 악보(마지막 악보)는 실수하지 않으므로 y-1
            sb.append(dp[y - 1] - dp[x - 1]).append("\n");
        }
        System.out.println(sb);
    }
}