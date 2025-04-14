package BOJ_9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 완전이진트리_박유진 {

  static int n, k ;
  static List<Integer> list;
  static List<List<String>> result;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    k = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    n = (int) Math.pow(2, k)-1 ; // 노드 총 개수

    list = new ArrayList<>();
    result = new ArrayList<>();

    for(int i=0; i<n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    // result 리스트 초기화
    result = new ArrayList<>();
    for(int i=0; i<k; i++) {
      result.add(new ArrayList<>());
    }

    go(0, n-1, 0 );

    for( List<String> l : result) {
      for (String s : l) {
        sb.append(s).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void go(int left, int right, int now) {
    if(now >= k || left >= right) {
      result.get(now).add(String.valueOf(list.get(left)));
      return;
    }

    int mid = (left + right) / 2;
    result.get(now).add(String.valueOf(list.get(mid)));

    go(left, mid-1, now+1);
    go(mid+1, right, now+1);
  }
}
