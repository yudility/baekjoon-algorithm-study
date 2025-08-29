package BOJ_1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1446
 */

public class 지름길_연예림 {

    static int N;
    static int D;
    static int[] distance;
    static List<List<Integer>> fast = new ArrayList<>();
    static int MAX = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        distance = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            fast.add(new ArrayList<>());
            distance[i] = i;                // 지름길이 없다고 가정했을 때의 최단거리
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            fast.get(b).addAll(List.of(a, w)); // 해당 도착지점을 기준으로 지름길의 시작, 거리를 저장
        }

        // 0 ~ 도착 까지 진행. 현재 도착지점까지 올수 있는 지름길을 확인하고 갱신
        for (int i = 0; i <= D; i++) {

            // 만약 현재 위치에 도착하는 지름길이 없는 경우 패스
            if (!fast.get(i).isEmpty()) {

                List<Integer> load = fast.get(i);

                for (int k = 0; k < load.size(); k += 2) {

                    // 시작 점까지의 최단거리 + 현재 지름길의 거리가 그냥 오는 거리보다 짧다면 갱신
                    int checkValue = distance[load.get(k)] + load.get(k+1);
                    if (checkValue < distance[i]) {
                        distance[i] = checkValue;
                    }
                }
            }

            // 다음에 그냥 한 칸 이동 했을 때를 갱신
            distance[i + 1] = Math.min(distance[i + 1], distance[i] + 1);
        }

        System.out.println(distance[D]);
    }
}
