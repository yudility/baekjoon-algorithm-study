package BOJ_9012;

import java.io.*;
import java.util.Stack;

public class 괄호_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        loop:
        for (int i=0; i<n; i++) {
            Stack<Character> s = new Stack<>();
            char[] charArr = br.readLine().toCharArray();

            for (int j=0; j<charArr.length; j++) {
                if (charArr[j] == '(') {
                    s.push(charArr[j]);
                } else {
                    if (s.isEmpty()) {
                        bw.write("NO\n");
                        continue loop;
                    } else {
                        s.pop();
                    }
                }
            }
            if (s.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }

        }
        br.close();
        bw.flush();
        bw.close();
    }
}

