package BOJ_18258;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/18258
public class 큐2_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken(" ");
            switch (cmd) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken(" ")));
                    break;
                case "pop":
                    bw.write(queue.isEmpty() ? "-1" + "\n"  : queue.poll() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write(queue.isEmpty() ? "1" + "\n" : "0" + "\n");
                    break;
                case "front":
                    bw.write(queue.isEmpty() ? "-1" + "\n" : queue.peek() + "\n");
                    break;
                case "back":
                    bw.write(queue.isEmpty() ? "-1" + "\n"  : ((LinkedList<Integer>) queue).getLast() + "\n");
                    break;
                default:
                    break;
            }
        }
        br.close();
        bw.close();
    }
}
