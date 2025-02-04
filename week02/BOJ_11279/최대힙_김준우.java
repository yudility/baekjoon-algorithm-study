package BOJ_11279;

import java.io.*;
import java.util.PriorityQueue;

public class 최대힙_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                bw.write(maxHeap.isEmpty() ? "0\n" : maxHeap.poll() + "\n");
            } else {
                maxHeap.add(num);
            }
        }
        bw.close();
        br.close();
    }
}
