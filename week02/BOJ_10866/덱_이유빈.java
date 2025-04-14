package BOJ_10866;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push_front")) {
                Integer num = Integer.parseInt(st.nextToken());
                deque.offerFirst(num);
            } else if (order.equals("push_back")) {
                Integer num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);
            } else if (order.equals("pop_front")) {
                if (deque.isEmpty()) bw.write("-1");
                else bw.write(String.valueOf(deque.pollFirst()));
                bw.write("\n");
            } else if (order.equals("pop_back")) {
                if (deque.isEmpty()) bw.write("-1");
                else bw.write(String.valueOf(deque.pollLast()));
                bw.write("\n");
            } else if (order.equals("size")) {
                bw.write(deque.size() + "\n");
            } else if (order.equals("empty")) {
                bw.write(deque.isEmpty() ? "1" : "0");
                bw.write("\n");
            } else if (order.equals("front")) {
                if (deque.isEmpty()) bw.write("-1");
                else bw.write(String.valueOf(deque.peekFirst()));
                bw.write("\n");
            } else if (order.equals("back")) {
                if (deque.isEmpty()) bw.write("-1");
                else bw.write(String.valueOf(deque.peekLast()));
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
