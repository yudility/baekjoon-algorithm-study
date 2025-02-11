package BOJ_20364;

import java.io.*;
import java.util.*;

public class 부동산다툼_이유빈 {
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        int[] duck = new int[q];
        for (int i=0; i<q; i++) {
            duck[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<q; i++) {
            solve(duck[i]);
        }
        System.out.println(sb);
    }

    static void solve(int ground) {
        int idx = ground;
        int ans = 0;

        while (idx != 0) {
            if (visited[idx]) ans = idx;
            idx /= 2;
        }
        sb.append(ans).append("\n");

        if (ans == 0) visited[ground] = true;
    }
}
