package BOJ_11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙_박유진 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.isEmpty()){
                    sb.append(x).append("\n");
                }
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{
                pq.add(x);
            }
        }
        System.out.println(sb);
    }

}
