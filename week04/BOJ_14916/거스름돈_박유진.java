package BOJ_14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_박유진 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max_x = n / 2;
        int max_y = n / 5;
        int minCoin = 50000;
        boolean flag = false;

        for (int i = 0; i <= max_y; i++) {
            for (int j = 0; j <= max_x; j++) {
                if (i * 5 + j * 2 == n) {
                    flag = true;
                    minCoin = Math.min(minCoin, i + j);
                }
            }
        }
        if (flag) {
            System.out.println(minCoin);
        }else{
            System.out.println(-1);
        }
    }

}
