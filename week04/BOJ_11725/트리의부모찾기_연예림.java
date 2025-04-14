package BOJ_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기_연예림 {
    static int[] parents;
    static List<LinkedList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        // 각 노드의 부모를 구하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 노드의 개수 N < 100_000
        int N = Integer.parseInt(br.readLine());

        // 각 노드의 부모 기록 arr
        parents = new int[N+1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N+1; i++) {
            graph.add(new LinkedList<>());
        }

        // 그래프 입력
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph.get(n).add(k);
            graph.get(k).add(n);
        }

        // 1부터 방문
        for (int i = 1; i < parents.length; i++) {
            if (parents[i] == 0) {
                dfs(i);
            }
        }

        // 출력
        for (int i = 2; i < parents.length; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {

        Deque<Integer> dq = new LinkedList<>();
        dq.offer(start);
        parents[start] = start;

        while (!dq.isEmpty()) {
            int parent = dq.pollLast();
            // 넣을 때 기록하기
            List<Integer> pollList = graph.get(parent);
            for (int i = 0; i < pollList.size(); i++){
                int addNode = pollList.get(i);
                if (parents[addNode] == 0) {
                    dq.offer(addNode);
                    parents[addNode] = parent;
                }
            }
        }
    }
}
