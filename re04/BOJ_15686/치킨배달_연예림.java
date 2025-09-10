package BOJ_15686;

// 백트래킹 + 조합 문제
import java.io.*;
import java.util.*;

class Node {
  int r;
  int c;

  Node(int r, int c) {
    this.r = r;
    this.c = c;
  }
}

public class 치킨배달_연예림
{
  static int n, m;
  static int min = Integer.MAX_VALUE;
  static List<Node> chickenList = new ArrayList<>();
  static List<Node> houseList = new ArrayList<>();
  static boolean[] open;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        int num = Integer.parseInt(st.nextToken());

        if (num == 1) {
          houseList.add(new Node(i, j));
        } else if (num == 2) {
          chickenList.add(new Node(i, j));
        }
      }
    }

    open = new boolean[chickenList.size()];
    dfs(0, 0);
    System.out.println(min);
  }

  // 백트래킹
  public static void dfs(int idx, int cnt) {
    if (cnt == m) {
      min = Math.min(min, calChickenDistance());
      return;
    }

    if (idx == chickenList.size()) return; // 더 뽑을 치킨집이 없는 경우

    // 조합을 만드는 패턴
    for (int i = idx; i < chickenList.size(); i++) {
      open[i] = true;
      dfs(i + 1, cnt + 1);
      open[i] = false;
    }
  }

  // 현재 오픈 상태인 치킨 가게 기준으로 계산
  public static int calChickenDistance() {
    int total = 0; // 도시 치킨 거리

    for (int i = 0; i < houseList.size(); i++) {
      int minDistance = Integer.MAX_VALUE;

      // 오픈한 치킨 집과의 모든 거리를 비교하고 최소 거리 구하기
      for (int j = 0; j < chickenList.size(); j++) {
        if (open[j]) {
          int distance = Math.abs(houseList.get(i).r - chickenList.get(j).r)
            + Math.abs(houseList.get(i).c - chickenList.get(j).c);
          minDistance = Math.min(minDistance, distance);
        }
      }
      total += minDistance;
    }
    return total;
  }
}
