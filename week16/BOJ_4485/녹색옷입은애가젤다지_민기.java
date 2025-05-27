package BOJ_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_민기 {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map, dist;
    static boolean[][] visited;

    // dx, dy 배열: 상하좌우 이동을 위한 배열
    // dx[i], dy[i] 조합으로 현재 위치 (x,y)에서 상하좌우 인접 칸을 쉽게 탐색할 수 있습니다.
    static int[] dx = {-1, 1, 0, 0}; // 상, 하
    static int[] dy = {0, 0, -1, 1}; // 좌, 우

    // 노드를 표현하는 클래스: 좌표(x, y)와 현재까지 누적 비용(cost)
    static class Node implements Comparable<Node> {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost; // 비용이 낮은 순서 우선 최소힙
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break; // N=0 이면 종료

            // 배열 초기화: map 에 비용, dist 에 최단비용 초기화
            map = new int[N][N];
            dist = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF; // 처음엔 모두 무한대로 세팅
                }
            }

            // 3) 다익스트라 수행 및 결과 출력
            int answer = dijkstra();
            System.out.printf("Problem %d: %d\n", tc++, answer);
        }

        br.close();
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드 초기 설정: dist에 시작 칸 비용(자기 자신)을 기록
        dist[0][0] = map[0][0];
        pq.offer(new Node(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 1) 가장 작은 cost의 노드를 꺼냄
            int x = cur.x, y = cur.y;

            // 이미 방문한 노드면 건너뜀
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            // 도착 지점이면 최단거리 확정
            if (x == N - 1 && y == N - 1) break;

            // 현재 위치에서 상, 하, 좌, 우로 이동 가능한 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 지도 범위 체크후 벗어나면 무시
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 이미 방문해서 최단 비용이 확정된 좌표는 제외
                if (visited[nx][ny]) continue;

                // 현재 위치를 거쳐 (nx, ny)로 이동할 경우의 누적 비용 계산
                int newCost = dist[x][y] + map[nx][ny];

                // 기존 비용보다 더 저렴한 경로라면 갱신하고, 큐에 삽입
                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;       // 더 작으면 갱신
                    pq.offer(new Node(nx, ny, newCost)); // 큐에 넣어 다음 탐색
                }
            }
        }

        // 최종 도착점까지의 최소 비용 반환
        return dist[N - 1][N - 1];
    }

}
