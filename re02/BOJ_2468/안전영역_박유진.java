package BOJ_2468;
import java.util.*;
import java.io.*;

public class 안전영역_박유진 {
    static int n;
    static int[][] areas = new int[101][101];
    static boolean[][] visited;
    static int answer = 1;
    static int maxLevel = 0;
    static int minLevel = 101;

    static int[] dy = {-1, 0 , 1, 0};
    static int[] dx = {0, -1 , 0, 1};

    static void dfs(int y, int x, int level){
      visited[y][x] = true;

      for(int i=0; i<4 ; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];

        if( ny <0 || nx <0 || nx >= n || ny >= n || visited[ny][nx] || areas[ny][nx] <= level) {
          continue;
        }
        dfs(ny, nx, level);
      }
    }



    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;

      n = Integer.parseInt(br.readLine());

      for(int i=0; i<n ; i++){
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++ ){
          areas[i][j] = Integer.parseInt(st.nextToken());
          maxLevel = Math.max(maxLevel, areas[i][j]);
          minLevel = Math.min(minLevel, areas[i][j]);

        }
      }

      for(int h = minLevel; h< maxLevel; h++){
        visited = new boolean[101][101];
        int count = 0;
        for(int i = 0; i < n ; i++){
          for(int j = 0; j < n; j++){
            if(!visited[i][j] && areas[i][j] > h){
              dfs(i, j, h);
              count++;
            }
          }
        }
        answer = Math.max(count, answer);
      }

      bw.write(answer+"");
      bw.flush();
      bw.close();
    }
  }

