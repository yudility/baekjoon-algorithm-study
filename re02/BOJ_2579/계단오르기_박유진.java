package BOJ_2579;

import java.util.*;
import java.io.*;

public class 계단오르기_박유진
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] s = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=0; i<n; i++){
            int score = Integer.parseInt(br.readLine());
            s[i+1] = score;
        }
        s[0] = 0;
        dp[0] = 0;
        dp[1] = s[1];

        if(n>=2){
            dp[2] = s[1]+s[2];
        }

        for(int i=3; i<=n; i++){
            //지금 칸 도착한 경우의 수
            //1. i-2 에서 올라온 경우,
            //   i에 오기 위해 i-1을 밟지 않음. 즉, i-2 -> i
            //   dp[i-2]에 s[i]를 더하면 된다.

            //2. i-1에서 올라온 경우,
            //   i에 오기 위해서 i-2를 밟지 않음. 즉, i-3 -> i-1 -> i
            //   d[i-3]에 s[i-1] s[i]

            dp[i] = Math.max(dp[i-2], dp[i-3]+s[i-1]) + s[i];
        }

        bw.write(dp[n] +"");
        bw.flush();
        bw.close();
	}
}
