package BOJ_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_김준우 {

  static int N;
  static int[] numbers;
  static int[] operations = new int[4];
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    numbers = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      operations[i] = Integer.parseInt(st.nextToken());
    }

    // numbers[0]은 연산의 시작값이고, 연산은 두 번째 숫자부터 시작해야 하므로 depth에 1을 넣고 시작합니다
    dfs(1, numbers[0]);

    System.out.println(max);
    System.out.println(min);
  }

  static void dfs(int depth, int current) {
    if (depth == N) {
      max = Math.max(max, current);
      min = Math.min(min, current);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (operations[i] > 0) {
        operations[i]--;
        int next = calculate(current, numbers[depth], i);
        // 연산자의 우선 순위를 무시하고 순차적으로 진행합니다
        dfs(depth + 1, next);
        operations[i]++;
      }
    }
  }

  static int calculate(int a, int b, int op) {
    switch (op) {
      case 0 :
        return a + b;
      case 1:
        return a - b;
      case 2:
        return a * b;
      case 3:
        if (a < 0) {
          return -(-a / b);
        } else {
          return a / b;
        }
    }
    return 0;
  }
}
