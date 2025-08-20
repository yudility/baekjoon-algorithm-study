package BOJ_2606;

import java.util.*;
import java.io.*;

public class 바이러스_연예림 {

  public static boolean[] visited;
  public static List<List<Integer>> links;
  public static int result = 0;

  public static void main(String[] args) throws IOException {

    // io
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 컴퓨터 수
    int nodeCnt = Integer.parseInt(br.readLine());
    visited = new boolean[nodeCnt+1];

    // 연결 수
    int linkCnt = Integer.parseInt(br.readLine());

    // 연결 정보 저장소
    links = new ArrayList();
    for (int i = 0; i < nodeCnt + 1; i++) {
      links.add(new ArrayList<>());
    }

    // 연결 입력
    for (int i = 0; i < linkCnt; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      links.get(n1).add(n2);
      links.get(n2).add(n1);
    }

    // 탐색 시작
    check(1);

    // result: 1번 컴퓨터를 통해 바이러스에 걸리는 컴퓨터의 수
    System.out.println(result);
  }

  public static void check(int start) {
    // 시작점 방문 처리
    visited[start] = true;

    // 시작점과 연결된 모든 정점을 deque에 입력
    Deque<Integer> deque = new LinkedList<>();
    deque.add(start);

    // deque이 비워질 때까지 반복
    while(!deque.isEmpty()) {

      // 꺼내오기
      int getNode = deque.poll();

      // 연결 노드 탐색
      for (int nextNode: links.get(getNode)) {

        // 방문 확인 후 방문 처리
        if (!visited[nextNode]) {
          result++;
          visited[nextNode] = true;
          deque.add(nextNode);
        }
      }
    }
  }
}
