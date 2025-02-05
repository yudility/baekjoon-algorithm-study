package BOJ_10866;

import java.io.*;
import java.util.*;

public class 덱_박유진 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        LinkedList<Integer> dq = new LinkedList<>();

        int n = Integer.parseInt(String.valueOf(br.readLine()));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();

            switch (comm) {
                case "push_front":
                    int xf = Integer.parseInt(st.nextToken());
                    dq.addFirst(xf);
                    break;
                case "push_back":
                    int xb = Integer.parseInt(st.nextToken());
                    dq.addLast(xb);
                    break;
                case "pop_front":
                    bw.write((dq.isEmpty() ? -1 : dq.pollFirst()) + "\n");
                    break;
                case "pop_back":
                    bw.write((dq.isEmpty() ? -1 : dq.pollLast()) + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write((dq.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((dq.isEmpty() ? -1 : dq.peekFirst()) + "\n");
                    break;
                case "back":
                    bw.write((dq.isEmpty() ? -1 : dq.peekLast()) + "\n");
                    break;
                default:
                    break;

            }
        }

        bw.flush();
        bw.close();
    }
}
