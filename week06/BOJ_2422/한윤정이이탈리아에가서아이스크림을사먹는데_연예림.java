package BOJ_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 한윤정이이탈리아에가서아이스크림을사먹는데_연예림 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<HashSet<Integer>> sets = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      sets.add(new HashSet<>());
    }

    // 입력
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (a < b) {
        sets.get(a).add(b);
      } else {
        sets.get(b).add(a);
      }
    }

    // 조합확인
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = i+1; j <= n; j++) {
        if (!sets.get(i).contains(j)) {
          for (int k = j+1; k <= n; k++) {
            if (!sets.get(i).contains(k) && !sets.get(j).contains(k)) {
              cnt++;
            }
          }
        }
      }
    }

    System.out.println(cnt);
  }
}
