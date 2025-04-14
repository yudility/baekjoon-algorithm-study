package BOJ_2503;

import java.io.*;
import java.util.*;

public class 숫자야구_박유진 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    boolean[] check = new boolean[1000];

    for (int i = 123; i <= 987; i++) {
      char one = String.valueOf(i).charAt(0);
      char two = String.valueOf(i).charAt(1);
      char three = String.valueOf(i).charAt(2);
      if (one == '0' || two == '0' || three == '0') {
        continue;
      }
      if (one == two || two == three || three == one) {
        continue;
      }
      check[i] = true;
    }

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      for (int cand = 123; cand <= 987; cand++) {
        if (!check[cand]) {
          continue;
        }
        int strike = 0;
        int ball = 0;
        for (int j = 0; j < 3; j++) {
          char score_digit = String.valueOf(num).charAt(j);
          for (int k = 0; k < 3; k++) {
            char cand_digit = String.valueOf(cand).charAt(k);
            if (cand_digit == score_digit && k == j) {
              strike++;
            } else if (cand_digit == score_digit) {
              ball++;
            }
          }
          if (strike == s && ball == b) {
            check[cand] = true;
          } else {
            check[cand] = false;
          }
        }
      }

    }
    int cnt = 0;
    for (boolean b : check) {
      if (b) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
