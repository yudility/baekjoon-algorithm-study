package BOJ_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5_박유진 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] acc = new int[n+1][n+1];

    for(int i =1; i<= n; i++){
      st = new StringTokenizer(br.readLine());
      acc[i][0] = 0;
      for(int j = 1; j<=n ; j++){
        int num = Integer.parseInt(st.nextToken());
        acc[i][j] = acc[i][j-1] + num;
      }
    }

    for(int i= 0; i< m ; i++){
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int sub = 0;
      for(int j= x1; j<=x2 ;j++ ){
        sub += acc[j][y1-1];
      }
      int total= 0;
      for(int j= x1; j<=x2; j++){
        total+= acc[j][y2];
      }

      sb.append(total-sub).append("\n");
    }
    System.out.println(sb);
  }
}
