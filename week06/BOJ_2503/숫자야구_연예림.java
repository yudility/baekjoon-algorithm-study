package BOJ_2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자야구_연예림 {

  public static void main(String[] args) throws IOException {
    // 불가능한 숫자 제외하기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 가능한 숫자 리스트
    boolean[] nums = new boolean[999];

    for (int i = 123; i <= 987; i++) {
      String s = String.valueOf(i);
      if (s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0') {
        continue;
      }
      if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(2) == s.charAt(0)) {
        continue;
      }
      nums[i] = true;
    }

    int n = Integer.parseInt(br.readLine());
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int strike = Integer.parseInt(st.nextToken());
      int ball = Integer.parseInt(st.nextToken());

      for (int j = 123; j <= 987; j++) {
        if (nums[j]) {
          int strikeCount = 0;
          int ballCount = 0;
          for (int k = 0; k < 3; k++) { // 비교하기
            String young = String.valueOf(j);
            for (int l = 0; l < 3; l++) {
              String min = String.valueOf(num);
              if(young.charAt(k) == min.charAt(l) && k == l) {
                strikeCount++;
              }
              if(young.charAt(k) == min.charAt(l) && k != l) {
                ballCount++;
              }
            }
          }

          if (strike != strikeCount || ball != ballCount) {
            nums[j] = false;
          }
        }
      }
    }

    for (int i = 123; i <= 987; i++) {
      if(nums[i]) {
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}
