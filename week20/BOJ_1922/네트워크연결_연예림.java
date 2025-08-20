package BOJ_1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크연결_연예림 {

    static class EdgeY {
        int cost;
        int node;

        public EdgeY(int cost, int node) {
            this.cost = cost;
            this.node = node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 인접 리스트 생성
        ArrayList<EdgeY>[] arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[a].add(new EdgeY(cost, b));
            arr[b].add(new EdgeY(cost, a));
        }

        System.out.println(prim(arr, N));
    }

    public static int prim(ArrayList<EdgeY>[] arr, int N) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<EdgeY> que = new PriorityQueue<>((e1, e2) -> e1.cost-e2.cost);
        que.offer(new EdgeY(0, 1)); // 시작 노드 1, 가중치 0

        int cnt = 0;
        int ans = 0;

        while (!que.isEmpty()) {
            EdgeY current = que.poll();
            int cost = current.cost;
            int node = current.node;

            if (visited[node]) { // 이미 방문한 노드의 간선이라면 패스
                continue;
            }

            visited[node] = true;
            ans += cost;
            cnt++;

            if (cnt == N) {
                break;
            }

            for (EdgeY next : arr[node]) { // 인접노드 큐에 추가
                if (!visited[next.node]) {
                    que.offer(next);
                }
            }
        }
        return ans;
    }
}

