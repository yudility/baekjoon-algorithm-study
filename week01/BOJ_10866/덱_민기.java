package BOJ_10866;

import java.io.*;
import java.util.*;

public class 덱_민기 {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // ArrayDeque를 사용한 덱(Deque) 구현
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.startsWith("push_front")) {
                // "push_front X" 에서 X 추출 후 덱의 앞쪽에 추가
                int num = Integer.parseInt(input.split(" ")[1]);
                deque.offerFirst(num);
            } else if (input.startsWith("push_back")) {
                // "push_back X" 에서 X 추출 후 덱의 뒤쪽에 추가
                int num = Integer.parseInt(input.split(" ")[1]);
                deque.offerLast(num);
            } else if (input.equals("pop_front")) {
                // 덱이 비어있으면 -1, 아니면 앞쪽 원소를 제거하여 출력
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (input.equals("pop_back")) {
                // 덱이 비어있으면 -1, 아니면 뒤쪽 원소를 제거하여 출력
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            } else if (input.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (input.equals("empty")) {
                sb.append(deque.isEmpty() ? "1" : "0").append("\n");
            } else if (input.equals("front")) {
                // 덱의 앞쪽 원소 조회, 비어있으면 -1 출력
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            } else if (input.equals("back")) {
                // 덱의 뒤쪽 원소 조회, 비어있으면 -1 출력
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
