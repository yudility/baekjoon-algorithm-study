package BOJ_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐2_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();     // 출력 시간 초과 문제로 StringBuilder 사용
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 큐 인터페이스 사용해서 구현
        LinkedList<Integer> queue = new LinkedList<>();

        // n번 반복
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":    // 큐에 정수 x 넣음
                    int x = Integer.parseInt(st.nextToken());
                    queue.offer(x);
                    break;

                case "pop":     // 큐 front에 있는 정수 빼고 출력
                    if (queue.isEmpty()) {  // 큐 비어있을 경우 -1 출력
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;

                case "size":    // 큐 들어있는 정수 개수 출력
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":   // 큐 비어있는지 여부 출력
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":   // 큐 front에 있는 정수 출력
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;

                case "back":    // 큐 rear에 있는 정수 출력
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.getLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}