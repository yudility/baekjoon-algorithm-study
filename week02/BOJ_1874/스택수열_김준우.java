package BOJ_1874;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 스택수열_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int cur = 1;
        boolean isPossible = true;
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            while (cur <= num) {
                stack.push(cur++);
                result.add("+");
            }
            if (stack.peek() == num) {
                stack.pop();
                result.add("-");
            } else {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            for (String s : result) {
                bw.write(s + "\n");
            }
        } else {
            bw.write("NO");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
