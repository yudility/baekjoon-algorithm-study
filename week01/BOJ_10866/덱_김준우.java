package BOJ_10866;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");
                    break;
                case "pop_back":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    bw.write(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
                    break;
                case "back":
                    bw.write(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
