package BOJ_1238;

import java.io.*;
import java.util.*;

// Town 클래스: 다익스트라 알고리즘에서 우선순위 큐에 사용될 객체
class Town implements Comparable<Town> {

  int to;    // 목적지 마을 번호
  int cost;  // 이동 비용(거리)

  // 생성자: 목적지와 비용을 초기화
  public Town(int to, int cost) {
    this.to = to;
    this.cost = cost;
  }

  // 우선순위 큐에서 비용이 적은 순서로 정렬하기 위한 비교 메소드
  @Override
  public int compareTo(Town o) {
    return this.cost - o.cost; // 비용이 적은 순서로 정렬
  }
}

public class 파티_박유진 {

  static int n, m, x;       // n: 마을 수, m: 도로 수, x: 파티가 열리는 마을 번호
  static List<Town>[] nList; // 정방향 인접 리스트 (일반적인 그래프)
  static List<Town>[] rList; // 역방향 인접 리스트 (모든 간선의 방향을 반대로 한 그래프)
  static int INF = 1_000_000_000; // 무한대 값 (연결되지 않은 경우를 표현)

  public static void main(String[] args) throws IOException {
    // 입력 처리를 위한 객체 생성
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 첫 줄 입력: 마을 수(n), 도로 수(m), 파티 장소(x) 읽기
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    // 인접 리스트 초기화 (1부터 n까지 인덱스 사용하기 위해 n+1 크기로 생성)
    nList = new ArrayList[n + 1];
    rList = new ArrayList[n + 1];
    for (int i = 0; i < n + 1; i++) {
      nList[i] = new ArrayList<>();
      rList[i] = new ArrayList<>();
    }

    // m개의 도로 정보 입력
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()); // 출발 마을
      int to = Integer.parseInt(st.nextToken());   // 도착 마을
      int cost = Integer.parseInt(st.nextToken()); // 이동 비용

      // 정방향 그래프에 간선 추가
      nList[from].add(new Town(to, cost));
      // 역방향 그래프에 간선 추가 (방향을 반대로)
      rList[to].add(new Town(from, cost));
    }

    // 다른 모든 마을에서 X 마을로 가는 최단 거리 계산
    // 역방향 그래프를 사용하여 X에서 다익스트라를 실행하면,
    // 실제로는 다른 모든 마을에서 X로 가는 최단 거리를 구할 수 있음
    int[] go = dijkstra(nList, x);

    // X 마을에서 다른 모든 마을로 돌아가는 최단 거리 계산
    int[] back = dijkstra(rList, x);

    // 가장 오래 걸리는 왕복 시간 찾기
    int res = Integer.MIN_VALUE;
    for (int i = 1; i < n + 1; i++) {
      // i번 마을의 경우: i→X 이동시간 + X→i 이동시간의 합
      int dis = go[i] + back[i];
      if (dis > res) {
        res = dis;
      }
    }

    // 결과 출력: 가장 오래 걸리는 왕복 시간
    System.out.println(res);
  }

  // 다익스트라 알고리즘: 시작점에서 모든 정점까지의 최단 거리를 계산
  static int[] dijkstra(List<Town>[] list, int start) {
    // 우선순위 큐: 비용이 적은 마을이 먼저 처리됨
    Queue<Town> q = new PriorityQueue<>();
    // 방문 체크 배열
    boolean[] check = new boolean[n + 1];
    // 최단 거리 배열, 초기값은 무한대
    int[] dp = new int[n + 1];
    Arrays.fill(dp, INF);

    // 시작점 초기화
    q.add(new Town(start, 0));
    dp[start] = 0;

    // 다익스트라 알고리즘 수행
    while (!q.isEmpty()) {
      // 현재 방문할 마을 (비용이 가장 적은 마을)
      Town pos = q.poll();
      int to = pos.to;

      // 이미 방문한 마을이면 스킵
      if (check[to]) {
        continue;
      }

      // 방문 표시
      check[to] = true;

      // 현재 마을과 연결된 모든 이웃 마을 확인
      for (Town next : list[to]) {
        // 현재까지의 거리 + 이웃까지의 거리가 기존 경로보다 짧다면 갱신
        if (dp[to] + next.cost < dp[next.to]) {
          dp[next.to] = dp[to] + next.cost;
          // 갱신된 거리로 우선순위 큐에 추가
          q.add(new Town(next.to, dp[next.to]));
        }
      }
    }

    // 계산된 최단 거리 배열 반환
    return dp;
  }
}
