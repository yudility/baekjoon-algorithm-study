package BOJ_11279;


import java.util.*;
import java.io.*;

public class 최대힙_민기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //최대힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                sb.append((maxHeap.isEmpty() ? "0" : maxHeap.poll()) + "\n");
            } else{
                maxHeap.add(num);
            }
        }
        System.out.println(sb);
    }
}
