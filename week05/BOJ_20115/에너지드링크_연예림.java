package BOJ_20115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에너지드링크_연예림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        // max 값 찾기, max가 아닌 값 들은 모두 2로 나누고 합치기
        double total = 0;
        int max = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; i++) {
            int next = Integer.parseInt(input[i]);
            if (next > max) {
                // next를 max에 넣고
                int temp = max;
                max = next;
                // max 값을 /2 하고 sum에 넣기
                total += temp / 2.0;
            } else {
                total += next / 2.0;
            }
        }
        total += max;
        System.out.println(total);
    }
}