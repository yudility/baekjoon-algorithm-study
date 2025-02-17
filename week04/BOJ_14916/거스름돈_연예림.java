package BOJ_14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_연예림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(calcMoney(n));
    }

    public static int calcMoney(int num) {
        // 만약 n 이 5 이하고 2, 4 가 아니라면
        if (num < 5 && num % 2 != 0) {
            return -1;
        }

        int m = num / 5;
        int n = num % 5;

        if (n == 0) {
            return m;
        } else if (n % 2 == 0) { // 나머지가 짝수인 경우
            return m + (n / 2);
        } else { // 홀수인 경우
            return (m - 1) + ((n + 5) / 2);
        }
    }
}
