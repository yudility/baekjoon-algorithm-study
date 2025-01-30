package BOJ_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 괄호_연예림 {
    public static void main(String[] args) throws IOException {
        // 입력도구
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // cnt
        int cnt = Integer.parseInt(br.readLine());

        // cnt 반복 짝 맞추기
        for (int i = 0; i < cnt; i++) {
            // 스택 수열
            Deque<Character> stack = new LinkedList<>();
            char[] input = br.readLine().toCharArray();
            boolean flag = true;

            for (char c : input) {
                if (c == '(') {
                    stack.offer(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peekLast() != '(') {
                        flag = false;
                        break;
                    }
                    stack.pollLast();
                }
            }
            sb.append((flag && stack.isEmpty() ? "YES" : "NO")).append("\n");
        }
        System.out.println(sb);
    }
}
