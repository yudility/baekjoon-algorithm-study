package BOJ_18258;

import java.util.*;
import java.io.*;

public class 큐2_민기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //arrayDeque 사용하여 양쪽에서 삽입 및 삭제 구현
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        //로직 구현
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            //push 명령 처리
            if (input.startsWith("push")) {
                //공백으로 나눈 후 정수를 추가
                int num = Integer.parseInt(input.split(" ")[1]);
                queue.offer(num);
            }
            else if (input.equals("pop")) {
                //큐가 비어있으면 -1 아니면 poll을 통해 결과 출력
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
