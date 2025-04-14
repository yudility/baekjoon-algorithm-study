package BOJ_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한윤정이이탈리아에가서아이스크림을사먹는데_박유진 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int all = N*(N-1)*(N-2)/6; // 조합 공식

    if( M == 0 ){ // 예외처리
      System.out.println(all);
    }

    boolean[][] arr = new boolean[N+1][N+1];

    int cnt = 0;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[a][b] = true;
      arr[b][a] = true;
    }

    for(int i = 1; i <= N; i++){
      for(int j = i+1; j <= N; j++){
        if(i==j) continue;
        if(arr[i][j] || arr[j][i] ) continue;
        for(int k = j+1; k <= N; k++){
          if(i==k || j==k ) continue;
          if(arr[j][k] || arr[k][j] || arr[i][k] || arr[k][i]) continue;
            cnt++;
        }
      }
    }

    System.out.println(cnt);
  }
}
