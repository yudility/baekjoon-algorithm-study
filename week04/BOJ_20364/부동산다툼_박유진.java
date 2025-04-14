package BOJ_20364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부동산다툼_박유진 {
    static int n;
    static int q;
    static boolean[] occupied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        // 점유 상태를 저장할 배열
        occupied = new boolean[n + 1];

        for(int i = 0; i < q; i++) {
            int target = Integer.parseInt(br.readLine());
            int result = findObstacle(target);

            if(result == 0) {  // 경로에 장애물이 없다면
                occupied[target] = true;  // 땅을 점유함
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    // 경로 상에서 가장 가까운 점유된 땅을 찾는 메서드
    static int findObstacle(int target) {
        int current = target;
        int obstacle = 0;

        // 리프에서 루트까지 올라가면서 체크
        while(current > 0) {
            if(occupied[current]) {
                // 가장 마지막에 발견된 장애물이 실제로는 가장 가까운 장애물
                obstacle = current;
            }
            current /= 2;  // 부모 노드로 이동
        }

        return obstacle;
    }
}