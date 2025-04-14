package BOJ_20115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 에너지드링크_박유진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] bev = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bev[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bev);

        double result = (double) bev[n-1];

        for(int i=n-2; i>=0; i--){
            result += (double) bev[i]/2;
        }

        System.out.println(result);
    }
}
