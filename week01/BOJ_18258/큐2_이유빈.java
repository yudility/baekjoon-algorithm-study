package BOJ_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 큐2_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.startsWith("push")) {
                int num = Integer.parseInt(input.split(" ")[1]);
                queue.offer(num);
            }
            else if (input.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                }
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else if (input.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
            else if (input.equals("empty")) {
                sb.append(queue.isEmpty() ? "1" : "0").append("\n");
            }
            else if (input.equals("front")) {
                if(queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.peekFirst()).append("\n");
                }
            }
            else if (input.equals("back")){
                if(queue.isEmpty()) {
                    sb.append("-1").append("\n");
                }
                else {
                    sb.append(queue.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}