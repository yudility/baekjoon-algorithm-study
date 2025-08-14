package BOJ_2606;

import java.util.*;
import java.io.*;

public class 유기농배추_박유진 {
  static int[] dy = {1, 0, -1, 0};
  static int[] dx = {0, 1, 0, -1};

  static void dfs(int nowX, int nowY, int[][] map, boolean[][] visited){
    visited[nowY][nowX] = true;
    //4방향 방문해보기
    for(int i=0; i<4; i++){
      int nextX = nowX + dx[i];
      int nextY = nowY + dy[i];
      if(nextX >= map[0].length || nextY >= map.length || nextX < 0 || nextY < 0 || visited[nextY][nextX]) continue;
      if(map[nextY][nextX] == 1){
        dfs(nextX, nextY, map, visited);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    while(t>0){
      int result = 0;

      StringTokenizer st = new StringTokenizer(br.readLine());

      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      int[][] map = new int[n][m];
      boolean[][] visited = new boolean[n][m];


      for(int i = 0 ; i< k ; i++){
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map[y][x] = 1;
      }

      for(int i=0; i< n ; i++){
        for(int j = 0; j<m; j++){
          if(!visited[i][j] && map[i][j] == 1) {
            dfs(j, i, map, visited);
            result++;
          };
        }
      }
      bw.write(result + "\n");
      t--;
    }
    bw.flush();
    bw.close();
  }
}
