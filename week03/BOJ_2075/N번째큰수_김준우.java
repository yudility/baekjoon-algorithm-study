package BOJ_2075;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken(" "));
                queue.add(num);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
