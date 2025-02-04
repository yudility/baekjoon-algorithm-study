package BOJ_11279;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String input = br.readLine();
            if (input.equals("0")) {
                if (heap.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(heap.poll()+"\n");
                }
            } else {
                heap.add(Integer.parseInt(input));
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
