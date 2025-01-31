package BOJ_9012;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 괄호_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean result = isVPS(st.nextToken());
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
        bw.close();
    }

    public static boolean isVPS(String string) {
        Queue<Character> queue = new LinkedList<>();
        char[] cArr = string.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == '(') {
                queue.add(cArr[i]);
            } else {
                if (queue.isEmpty()) {
                    return false;
                } else {
                    queue.poll();
                }
            }
        }
        if (queue.isEmpty()) {
            return true;
        }
        return false;
    }
}
