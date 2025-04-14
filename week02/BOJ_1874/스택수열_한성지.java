package BOJ_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());    // 1 ~ n까지의 수

        Stack<Integer> stack = new Stack<>();

        // 스택에 n까지 수를 넣기 위한 변수
        int count = 1;

        // n번 반복
        loopOut:
        for (int i = 1; i <= n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (count <= n + 1) {
                if (stack.contains(target)) { 
                    if (stack.peek() == target) {   // 스택이 타겟을 가지고 있고, peek가 target일 경우
                        // 가장 위에 있는 요소를 삭제하고 "-" 출력
                        stack.pop();   
                        sb.append("-\n");
                        continue loopOut;   // 다음 타겟으로
                    } else {
                        break loopOut;  // 스택이 타겟을 가지고 있고 peek가 아닐 경우 수열을 만들 수 없으므로 NO 출력
                    }
                } else {
                    // 스택이 타겟을 가지고 있지 않다면 타겟까지 push
                    stack.push(count);
                    sb.append("+\n");
                    count++;
                }
            }
        }

        // 반복문이 끝나고 스택이 비어있지 않다면 수열을 만들 수 없으므로 NO 출력
        if (!stack.isEmpty()) {
            sb.setLength(0);
            sb.append("NO");
        }

        System.out.print(sb);
    }
}
