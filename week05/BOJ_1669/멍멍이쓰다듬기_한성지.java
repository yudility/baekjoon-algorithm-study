package BOJ_1669;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멍멍이쓰다듬기_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        long sub = Y - X;

        if (sub == 0) {         // 키 같을 경우 예외처리
            System.out.println(0);
        }

        long N = 1;
    
        while (N * N <= sub) {      // 키 차이보다 작은 최대 제곱수 찾음 -> 최대 고점
            N++;
        }

        N --;     // N++ 된 상태로 while문을 빠져나오기 떄문에 -1 해줌
        long answer = 2 * N - 1; // answer 초기값 설정

        sub -= (N * N);   // 제곱수만큼 빼고 남은 키로 계산
        if (sub > 0) {
            if (sub <= N) answer ++;    // 남은 값이 N 이하이면 한 번만 더 이동
            else answer += 2;           // 남은 값이 N 초과이면 두 번 이동 필요
        }
        System.out.println(answer);
    }
}