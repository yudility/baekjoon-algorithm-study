package BOJ_15686;

import java.util.*;
import java.io.*;

public class 치킨배달_박유진 {

  static int n, m;

  // 치킨집 조합들 ex) {0, 1, 2}, {0, 2, 3}, ...}
  static ArrayList<ArrayList<Integer>> chickenCombi = new ArrayList<>();

  static class XY {
    int x;
    int y;

    XY(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  static void getChickenCombis(int idx, int total, ArrayList<Integer> combi) {
    // 만든 조합의 원소 개수가 m(남겨야하는 치킨집 수)개 라면 조합을 하나 완성했으므로 조합 리스트에 추가
    if (combi.size() == m) {
      chickenCombi.add(new ArrayList<>(combi));
      return;
    }

    for (int i = idx; i < total; i++) {
      combi.add(i); // 조합에 넣기
      getChickenCombis(i + 1, total, combi); // 다음 원소 고르기
      combi.remove(combi.size() - 1); // 조합에서 빼기
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    ArrayList<XY> chickens = new ArrayList<>(); // 치킨 집 정보를 담을 배열
    ArrayList<XY> homes = new ArrayList<>();  // 집 정보를 담을 배열
    ArrayList<Integer> combi = new ArrayList<>(); // 남길 치킨 집 조합을 임시로 담을 배열

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int now = Integer.parseInt(st.nextToken());
        if (now == 2) { // 치킨집
          chickens.add(new XY(i, j));
        } else if (now == 1) { // 집
          homes.add(new XY(i, j));
        }
      }
    }

    getChickenCombis(0, chickens.size(), combi); // 조합 구하기

    int result = Integer.MAX_VALUE; // 결과 값을 담을 곳

    for (int k = 0; k < chickenCombi.size(); k++) {// 위에서 구했던 남길 치킨집 조합 경우의 수 만큼 반복
      // ex) chickenCombi => { {0, 1, 2}, {0, 2, 3}, ... }

      int chickDist = 0; //각 조합마다의 치킨 거리
      for (int i = 0; i < homes.size(); i++) { //각 집마다의 치킨 거리 구하기
        XY home = homes.get(i);
        int dist = Integer.MAX_VALUE; //치킨 거리
        // 특정 조합의 치킨집마다 치킨 거리 구하기
        for (int j = 0; j < chickenCombi.get(k).size(); j++) {
          // ex) chickenCombi.get(k) => {0, 1, 2}
          // ex) chickenCombi.get(k).get(j) => 1 (치킨집 인덱스)
          int chickenIdx = chickenCombi.get(k).get(j);
          XY chicken = chickens.get(chickenIdx);

          // 남은 치킨집을 모두 돌면서, 해당 집과 치킨집의 최단 거리를 구함
          dist = Math.min(dist, Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y));
        }
        // 구한 최단 거리를 더해 치킨 거리를 구함
        chickDist += dist;
      }
      // 구한 치킨 거리중 최소 값 구하기
      result = Math.min(result, chickDist);
    }

    System.out.println(result);
  }
}