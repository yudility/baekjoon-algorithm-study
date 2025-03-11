package BOJ_20438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개똥벌레_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 동굴 길이
        int H = Integer.parseInt(st.nextToken());   // 동굴 높이

        int[] down = new int[H + 2];  // 석순 개수 저장
        int[] up = new int[H + 2];    // 종유석 개수 저장

        for (int i = 1; i <= N / 2; i++) {
            int a = Integer.parseInt(br.readLine());            // 석순 높이
            int b = H - Integer.parseInt(br.readLine()) + 1;    // 종유석 높이

            down[a]++;  // 해당 높이의 석순 개수 증가
            up[b]++;    // 해당 높이의 종유석 개수 증가
        }

        // 누적합
        for (int i = 1; i <= H; i++) {
            // 높이 i 이하의 석순 개수 누적합
            down[i] += down[i - 1];
        }

        for (int i = H; i >= 1; i--) {
            // 높이 i 이상의 종유석 개수 누적합
            up[i] += up[i + 1];
        }

        int min = N;    // 최소 장애물 개수
        int cnt = 0;    // 최소 개수를 가지는 구간 개수

        for (int i = 1; i < H + 1; i++) {
            // i 이상의 석순 개수 + i 이하의 종유석 개수
            int dif = (down[H] - down[i - 1]) + (up[1] - up[i + 1]);

            if (dif < min) {
                min = dif;
                cnt = 1;
            } else if (dif == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }
}