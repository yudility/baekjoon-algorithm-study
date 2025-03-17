package BOJ_11441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 합구하기_박유진 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    // n < 100,000
    // -1000 <Ai < -1000
    // 구간의 개수 m개
    // 넷째 줄부터 M개의 줄 각구간 i <= j

    List<Integer> acc = new ArrayList<>();

    int n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    //입력 받으면서 누적합 저장
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        acc.add(Integer.parseInt(st.nextToken()));
        continue;
      }
      acc.add(acc.get(i - 1) + Integer.parseInt(st.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());

    for (int k = 0; k < m; k++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      if(i==1){
        sb.append(acc.get(j-1)).append("\n");
      }else{
        sb.append(acc.get(j-1) - acc.get(i - 2)).append("\n");
      }
    }

    System.out.println(sb);
  }
}
