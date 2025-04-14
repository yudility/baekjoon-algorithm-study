package BOJ_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());    // 테스트 t개

        // t번 반복
        loop:
        for (int i = 0; i < t; i++) {
            // BufferedReader를 통해 받은 문자를 split으로 잘라 배열로 만듦
            String[] parentheses = br.readLine().split("");

            // 문자열 배열 길이가 홀수개인 경우 괄호 짝 안맞으므로 sb에 NO 넣음
            if (parentheses.length % 2 != 0) {
                sb.append("NO\n");
                continue;
            }

            // stack 생성
            Stack<String> stack = new Stack<>();

            // 괄호 개수만큼 반복
            for (int j = 0; j < parentheses.length; j++) {
                String input = parentheses[j];

                // "("일 경우 stack에 push
                if (input.equals("(")) {
                    stack.push(input);
                } else {    // ")"일 경우
                    if (!stack.isEmpty()) { // 스택에 "(" 들어있을 경우
                        stack.pop();        // 닫힌 괄호는 스택에서 삭제
                    } else {                // 스택에 "(" 없을 경우
                        sb.append("NO\n");  // sb에 NO 넣음
                        continue loop;      // 인덱스를 통해 바깥 반복문 다음 단계 실행
                    }
                }
            }

            // 반복문 끝난 후 스택 비어있으면 YES, 아니면 NO
            if (stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        // 출력
        System.out.print(sb);
    }
}
