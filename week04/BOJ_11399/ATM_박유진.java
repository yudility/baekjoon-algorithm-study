package BOJ_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_박유진 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] p = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            p[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        int pre = 0;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += p[i]+pre;
            pre += p[i];
        }
        System.out.println(sum);
    }

}

