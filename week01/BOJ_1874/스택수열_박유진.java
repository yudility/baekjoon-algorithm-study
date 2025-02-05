package BOJ_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열_박유진 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();
        int i = 1;

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int a = Integer.parseInt(br.readLine());

            if(stack.isEmpty() || stack.peek() < a) {
                while(i<=a){
                    stack.push(i++);
                    builder.append("+\n");
                }
            }
            if (stack.peek().equals(a)) {
                stack.pop();
                builder.append("-\n");
            } else {
                flag = false;
                break;
            }
        }

        if (!flag) {
            System.out.println("NO");
        } else {
            System.out.print(builder);
        }
    }
}
