package BOJ_20364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5분
public class 부동산다툼_연예림 {
    public static void main(String[] args) throws IOException {
        // 입력, 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N: 땅, Q: 오리 수
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);

        // N + 1 개의 땅 생성 (boolean 배열 - 점유 여부)
        boolean[] area = new boolean[N+1];
        // 오리
        int[] ducks = new int[Q];
        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = Integer.parseInt(br.readLine());
        }

        // 도달하려는 땅에서 시작 -> 1까지 /2 연산
        // 1에 도달하기 전에 처음 점유된 땅을 만나면 실패
        // noArea 점유된 땅을 기록하고 가장 첫번째(가장 작은 숫자)를 입력
        // noArea가 null이면 0출력
        for (int i = 0; i < ducks.length; i++) {
            int last = -1;
            int to = ducks[i];
            while (to > 0) {
                if (area[to]) {
                    last = to;
                }
                to /= 2;
            }

            if (last == -1) {
                area[ducks[i]] = true;
                sb.append(0).append("\n");
            } else {
                sb.append(last).append("\n");
            }
        }

        System.out.println(sb);
    }
}
