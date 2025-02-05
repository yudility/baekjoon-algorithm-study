package BOJ_11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        // 우선순위 큐 생성
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        // n번 반복
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());    // 배열에 넣을 자연수

            if (x > 0) {    // x가 자연수인 경우
                heap.add(x); // 힙에 넣음
            } else if (x == 0){ // 0인 경우
                // 힙이 비어있는 경우 0, 아닌 경우 루트를 반환하고 삭제
                sb.append(heap.isEmpty() ? 0 : heap.poll()).append("\n");
            }
        }

        System.out.print(sb);
    }
}