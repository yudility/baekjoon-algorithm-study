package BOJ_18258;

import java.io.*;
import java.util.*;

public class 큐2_박유진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        LinkedList<Integer> list = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    list.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write((list.isEmpty() ? -1 : list.poll()) + "\n");
                    break;
                case "size":
                    bw.write(list.size() + "\n");
                    break;
                case "empty":
                    bw.write((list.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((list.isEmpty() ? -1 : list.getFirst()) + "\n");
                    break;
                case "back":
                    bw.write((list.isEmpty() ? -1 : list.getLast()) + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}