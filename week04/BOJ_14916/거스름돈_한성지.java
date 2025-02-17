package BOJ_14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 거스름돈 액수
        int n = Integer.parseInt(br.readLine());

        int f = n / 5;  // 5원 최대 개수

        int answer = -1;    // 거슬러줄 수 없는 경우 -1

        // 5원 개수를 하나씩 줄여가며 동전 개수가 가장 적은 경우 찾아내기
        for (int i = f; i >= 0; i--) {
            if ((n - 5 * i) % 2 == 0) {   // 거슬러 줄 수 있는 경우일 때
                
                int coin = i + (n - 5 * i) / 2;     // 동전 개수
                
                if (answer == -1 || answer > coin) {
                    answer = coin;
                }
            }
        }

        System.out.println(answer);
    }
}