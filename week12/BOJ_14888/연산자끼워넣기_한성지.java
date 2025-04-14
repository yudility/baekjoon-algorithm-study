package BOJ_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_한성지 {

  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  static int N; // 수의 개수
  static int[] number; // 수
  static int[] operator = new int[4];  // 연산자 개수 (+, -, ×, ÷)

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    number = new int[N];

    // 수 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      number[i] = Integer.parseInt(st.nextToken());
    }

    // 연산자 개수 저장
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }

    dfs(number[0], 1);

    System.out.println(max);
    System.out.println(min);
  }

  public static void dfs(int num, int idx) {
    if (idx == N) {
      max = Math.max(max, num);
      min = Math.min(min, num);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (operator[i] > 0) {
        
        // 해당 연산자 1 뺌
        operator[i]--;

        switch (i) {
          case 0: // 더하기
            dfs(num + number[idx], idx + 1); break;
          case 1: // 빼기
            dfs(num - number[idx], idx + 1); break;
          case 2: // 곱하기
            dfs(num * number[idx], idx + 1); break;
          case 3: // 나누기
            dfs(num / number[idx], idx + 1); break;
        }

        // 다시 원래대로 원상복구
        operator[i]++;
      }
    }
  }
}