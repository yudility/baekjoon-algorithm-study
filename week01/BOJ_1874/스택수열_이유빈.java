package BOJ_1874;

import java.io.*;
import java.util.Stack;

public class 스택수열_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num > start) {
                for (int i=start+1; i<=num; i++) {
                    stack.push(i);
                    bw.write("+\n");
                }
                start = num;
            }

            else if (stack.peek() != num) {
                bw.write("NO");
                return;
            }
            stack.pop();
            bw.write("-\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
