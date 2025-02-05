package BOJ_2075;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int k=0; k<n-1; k++) {
            queue.poll();
        }

        bw.write(queue.poll() + "");
        br.close();
        bw.flush();
        bw.close();
    }
}
