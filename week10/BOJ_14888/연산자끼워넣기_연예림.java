package BOJ_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_연예림 {
  public static int MAX = Integer.MIN_VALUE;
  public static int MIN = Integer.MAX_VALUE;
  public static int[] operator = new int[4];
  public static int[] number;
  public static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 숫자 개수
    N = Integer.parseInt(br.readLine());
    number = new int[N];

    // 숫자 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      number[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < 4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }

    dfs(number[0], 1); // 피연산자 a와 b의 인덱스

    System.out.println(MAX);
    System.out.println(MIN);

  }

  public static void dfs(int num, int idx) {
    if (idx == N) {
      MAX = Math.max(MAX, num);
      MIN = Math.min(MIN, num);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (operator[i] > 0) { // 연산자 개수 확인

        operator[i]--;

        switch (i) {

          case 0:
            dfs(num + number[idx], idx + 1);
            break;
          case 1:
            dfs(num - number[idx], idx + 1);
            break;
          case 2:
            dfs(num * number[idx], idx + 1);
            break;
          case 3:
            dfs(num / number[idx], idx + 1);
            break;

        }

        operator[i]++; // 연산자 개수 복구
      }
    }
  }
}
