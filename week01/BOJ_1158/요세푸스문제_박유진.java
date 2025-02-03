package BOJ_1158;

import java.io.*;
import java.util.*;

public class 요세푸스문제_박유진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> ll = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            ll.add(i+1);
        }
        bw.write("<");
        while(ll.size()>1){
            for(int j=0; j<k-1; j++){
                ll.add(ll.poll());
            }
            bw.write(ll.poll()+", ");
        }
        bw.write(ll.poll()+">");

        bw.flush();
        bw.close();
    }
}
