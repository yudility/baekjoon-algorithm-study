package BOJ_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 35분
public class 계란으로계란치기_연예림 {

  static int N;
  static int max;
  static int[][] eggs;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    eggs = new int[N][2];

    // (N x 2) 이차원 배열
    StringTokenizer st;
    for (int i = 0; i < eggs.length; i++) {
      st = new StringTokenizer(br.readLine());
      eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
      eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
    }

    getEggMax(0, 0);

    System.out.println(max);

  }

  // N 번 반복: 손에 든 계란 (내구도가 < 0 이면 패스)
  // idx 현재 계란이 깨지면, idx + 1 다음 게란으로 넘어간다.
  public static void getEggMax(int idx, int cnt) {
    if (idx == N) {
      if (cnt > max) {
        max = cnt;
      }
      return;
    }

    if (eggs[idx][0] <= 0) { // 손에 든 달걀이 깨져있으면 다음 달걀 들기
      getEggMax(idx + 1, cnt);
      return;
    }

    boolean target = false; // 다른 달걀이 모두 깨진 경우를 고려
    for (int i = 0; i < N; i++) { // 모든 달걀 중 하나치기

      if (i == idx || eggs[i][0] <= 0) continue; // 이미 깨진 달걀, 내 달걀은 치지 않음

      target = true;

      eggs[i][0] -= eggs[idx][1];
      eggs[idx][0] -= eggs[i][1];

      int check = 0; // 깨진 달걀 수
      if (eggs[i][0] <= 0) check++; // 등호 조건은 빼먹었었음.
      if (eggs[idx][0] <= 0) check++;
      getEggMax(idx + 1, cnt + check);

      // 백트래킹
      eggs[i][0] += eggs[idx][1];
      eggs[idx][0] += eggs[i][1];

    }

    if (!target || idx == N-1) { // 깰 계란이 없거나 마지막 계란인 경우
      getEggMax(idx + 1, cnt);
    }

  }

}
