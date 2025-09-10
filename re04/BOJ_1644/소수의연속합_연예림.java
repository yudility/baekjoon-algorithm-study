package BOJ_1644;

import java.util.*;
import java.io.*;

public class 소수의연속합_연예림
{
  static final int max = 4000000;
  static boolean[] notSosu = new boolean[max + 1];

  public static void main(String[] args) throws IOException {

    setSosu();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Deque<Integer> depue = new LinkedList<>();
    int count = 0;
    int sum = 0;

    for (int i = N; i > 1; i--) {

      if (notSosu[i]) {
        continue;
      }

      sum += i;
      depue.add(i);

      if (sum > N) { // 클 때, 가장 처음 더해진 값 빼기
        sum -= depue.poll();
      }

      if (sum == N) { // 같을 때, 가장 처음 더해진 값 빼기
        count++;
        sum -= depue.poll();;
      }
    }

    System.out.println(count);
  }

  public static void setSosu() {
    notSosu[0] = true;
    notSosu[1] = true;

    for (int i = 2; i <= Math.sqrt(max); i++) {

      for (int j = i + i; j <= max; j = j + i) {
        notSosu[j] = true;
      }
    }
  }
}