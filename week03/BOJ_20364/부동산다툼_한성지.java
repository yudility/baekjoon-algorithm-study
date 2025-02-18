package BOJ_20364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부동산다툼_한성지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 땅 개수
        int q = Integer.parseInt(st.nextToken());   // 오리 수

        // 인덱스 쉽게 사용하기 위해 n+1개 배열 선언 -> 인덱스 사용 시 -1 처리 안해도 됨
        boolean[] visited = new boolean[n + 1];     // 해당 땅 점유 여부

        // 원하는 땅부터 root까지 올라감
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int firstMeetPosition = 1;

            // 부모 노드는 무조건 자식/2
            for (int j = num; j >= 2; j /= 2) {
                // 땅 점유 성공 여부 확인
                if (visited[j]) {
                    flag = true;
                    firstMeetPosition = j;
                }
            }

            if (flag) {     // 땅 점유 실패 시
                System.out.println(firstMeetPosition);
            } else {        // 땅 점유 성공 시
                visited[num] = true;
                System.out.println(0);
            }
        }
    }
}