package BOJ_20438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 출석체크_이유빈 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    boolean[] check = new boolean[n+3]; // 출석 코드 받은 학생
    List<Integer> sleep = new ArrayList<>(); // 조는 학생
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<k; i++) {
      sleep.add(Integer.parseInt(st.nextToken()));
    }

    // 출석 코드 전송 확인(조는 학생 제외)
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<q; i++) {
      int now = Integer.parseInt(st.nextToken());
      if (!sleep.contains(now)) {
        if (!check[now]) {
          for (int j=now; j<n+3; j++) {
            if (j % now == 0 && !sleep.contains(j)) {
              check[j] = true;
            }
          }
        }
      }
    }

    int[] prefix = new int[n+3];
    for (int i=3; i<prefix.length; i++) {
      prefix[i] = prefix[i-1] + (!check[i] ? 1 : 0);
    }

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(prefix[b] - prefix[a-1]);
    }
  }
}
