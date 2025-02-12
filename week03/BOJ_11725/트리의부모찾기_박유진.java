package BOJ_11725;
import java.util.*;
import java.io.*;

public class 트리의부모찾기_박유진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 인접 리스트로 트리 구현
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 연결 관계 저장
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        // BFS로 부모 찾기
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int child : tree[current]) {
                if (!visited[child]) {
                    parent[child] = current;
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

        // 결과 출력
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
}