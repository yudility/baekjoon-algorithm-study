package BOJ_11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙_연예림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");

            } else {
                pq.offer(input);
            }
        }
        System.out.println(sb);
    }
}
