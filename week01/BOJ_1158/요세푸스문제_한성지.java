package BOJ_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("<");

        int n = Integer.parseInt(st.nextToken());   // n명
        int k = Integer.parseInt(st.nextToken());   // 제거할 사람 (k번째)

        Queue<Integer> queue = new LinkedList<>(); 

        // queue에 숫자 채우기
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // queue가 빌 때까지
        while (!queue.isEmpty()) {

            // queue의 k번째 앞까지 위치한 사람을 rear로 보냄(정렬)
            for (int i = 1; i < k ; i++) {
                int num = queue.poll();
                queue.offer(num);
            }

            // k번째 사람을 queue에서 제거
            sb.append(queue.poll());

            // 마지막 사람은 , 붙이지 않음
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        // 출력
        System.out.println(sb.append(">"));
    }
}