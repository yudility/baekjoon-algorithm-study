package BOJ_9012;

import java.io.*;
import java.util.Stack;

public class 괄호_박유진 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(String.valueOf(br.readLine()));

        for (int i = 0; i < n; i++) {

            Stack<Integer> st = new Stack<>();

            String s = String.valueOf(br.readLine());

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    st.push(0);
                }
                if (s.charAt(j) == ')') {
                    if (st.isEmpty()) {
                        st.push(0);
                        break;
                    } else {
                        st.pop();
                    }
                }
            }

            if (!st.isEmpty()) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }
        bw.flush();
        bw.close();

    }
}

