package BOJ_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 강의실배정_박유진 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(a, b);
        }
        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start? l1.end - l2.end : l1.start - l2.start );

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for(int i = 1; i < n ; i++){
            if(pq.peek() <= lectures[i].start){
                pq.poll();
            }
            pq.offer(lectures[i].end);
        }

        System.out.println(pq.size());
    }

    static class Lecture{
        int start;
        int end;
        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

}
