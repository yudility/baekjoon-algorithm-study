package BOJ_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체_연예림 {

    static boolean[] arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        // N보다 작거나 같은 모든 소수를 찾는 알고리즘
        
        // 2 ~ N 모두적기
        // 아직 지우지 않는 수 중 가장 작은 수 찾기 P (소수)
        // P를 지우고, 아직 지우기 않은 P의 배수를 크기 순서대로 지운다.
        // N, K => K 번째 지우는 수;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1];

        System.out.println(getK());

    }

    static int getK() {
        int cnt = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j = i; j < arr.length; j+=i) {
                if (!arr[j]) {
                    arr[j] = true;
                    cnt++;
                }
                if (cnt == K) {
                    return j;
                }
            }
        }
        return 0;
    }
}
