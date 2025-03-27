package BOJ_20438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 출석체크_한성지 {

    static boolean[] students;      // 출석 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());   // 1번째 줄 학생 수
        int K = Integer.parseInt(st.nextToken());   // 졸고 있는 학생 수
        int Q = Integer.parseInt(st.nextToken());   // 지환이가 출석코드 보낼 학생의 수
        int M = Integer.parseInt(st.nextToken());   // 주어질 구간의 수

        students = new boolean[N + 3];

        st = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            students[num] = true;  // 졸고 있는 경우 true 저장
        }

        st = new StringTokenizer(br.readLine());
        boolean[] code = new boolean[N + 3];    // 코드 받은 학생
        while (Q-- > 0) {  
            int num = Integer.parseInt(st.nextToken());
            if (students[num]) continue;    // 코드 받은 학생이 졸고 있는 경우 코드를 보낼 수 없으므로 다음 루프 진행
            for (int i = num; i <= N + 2; i += num) {
                code[i] = true; // 코드 전달 받은 경우 true 표시
            }
        }

        for (int i = 3; i <= N + 2; i++) {
            if (!code[i]) {
                students[i] = true;     // 졸고 있거나 코드를 받지 않은 학생을 true로 체크
            }
        }

        long[] dp = new long[N + 3];
        // dp
        for (int i = 3; i < N + 3; i++) {
            dp[i] = dp[i - 1] + (students[i] ? 1 : 0);  // 출석하지 않은 학생 수 누적합
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append((dp[b] - dp[a-1])).append("\n");
        }

        System.out.println(sb);
    }
}