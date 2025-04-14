package BOJ_1874;

import java.io.*;
import java.util.*;

public class 스택수열_민기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int current = 1;  // 스택에 넣을 다음 숫자

        for(int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            // target까지 push
            while(current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // pop해서 나오는 숫자가 target과 다르면 불가능
            if(stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);

        //고민들
        //입력값을 담을 곳은 어디로 정하지...?

        //예시를 기준으로 2에서 5사이를 계속 push한 다음 그 사이값들을 pop으로 빼버리는 로직 필요

        //구현이 불가능하다는건 어떻게 판단을 할것인가
    }
}
