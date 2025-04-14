package BOJ_11725;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for (int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        // BFS (Breadth First Search)
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
                parent[next] = cur;
            }
        }

        for (int i=2; i<=n; i++) {
            bw.write(parent[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
