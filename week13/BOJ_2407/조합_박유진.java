package BOJ_2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 조합_박유진 {

  static BigInteger[][] combi;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    // 조합 n에 들어가는 자연수
    int n = Integer.parseInt(st.nextToken());
    // 조합 r에 들어가는 자연수
    int r = Integer.parseInt(st.nextToken());

    // 메모이제이션 배열 초기화
    combi = new BigInteger[n + 1][n + 1];

    // 배열 초기화 (null 방지)
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        combi[i][j] = BigInteger.valueOf(-1);
      }
    }

    //DFS 탐색 시작
    System.out.println(DFS(n, r));

  }

  static BigInteger DFS(int n, int r) {
    // 해당 메모이제이션이 이미 존재하는 경우,
    if (combi[n][r].compareTo(BigInteger.valueOf(-1)) != 0) {
      // 존재하는 값 return
      return combi[n][r];
    }

    // n==r : n개 중 n개를 뽑는 경우의 수는 오직 1개
    // r==0 : n개 중 하나도 뽑지 않는 경우의 수는 오직 1개
    // 조합식 return
    if (n == r || r == 0) {
      return BigInteger.valueOf(1);
    }
    // 이외의 경우,
    else {
      return combi[n][r] = DFS(n - 1, r - 1).add(DFS(n - 1, r));
    }
  }
}