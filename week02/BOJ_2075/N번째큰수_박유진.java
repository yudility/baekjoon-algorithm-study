package BOJ_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//자바 15 메모리 초과
//자바 11 통과
public class N번째큰수_박유진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i< n-1; i++){
            pq.remove();
        }
        System.out.println(pq.poll());


    }
}
