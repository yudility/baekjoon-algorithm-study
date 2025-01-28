package BOJ_1158;

import java.io.*;
import java.util.*;

public class 요세푸스문제_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            list.add(queue.poll());
        }

        bw.write("<");
        for (int i = 0; i < list.size(); i++) {
            bw.write(String.valueOf(list.get(i)));
            if (i < list.size() - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");

        br.close();
        bw.close();
    }
}
