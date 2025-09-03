package BOJ_7569;

import java.util.*;
import java.io.*;

public class 토마토_박유진
{
  static int m, n, h;
  static int[][][] tomatos;
  static int dy[] = {1, 0, -1, 0, 0, 0};
  static int dx[] = {0, 1, 0, -1, 0, 0};
  static int dz[] = {0, 0, 0, 0, 1, -1};

  static class Tomato{
    int z;
    int y;
    int x;

    Tomato(int z, int y, int x){
      this.z = z;
      this.y = y;
      this.x = x;
    }
  }

  static boolean check(int nz, int ny, int nx, int[][][] tomatos){

    if(nz < 0 || ny < 0  || nx < 0 || nz >= h || ny >= n || nx >= m ) return false;
    if(tomatos[nz][ny][nx] == 0) return true;
    return false;

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n= Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    tomatos = new int[h][n][m];
    Queue<Tomato> q = new LinkedList<>();

    for(int i=0; i<h; i++){
      for(int j=0; j<n; j++){
        st = new StringTokenizer(br.readLine());
        for(int k = 0; k<m; k++){
          tomatos[i][j][k] = Integer.parseInt(st.nextToken());
          if(tomatos[i][j][k] == 1){
            q.add(new Tomato(i, j, k));
          }
        }
      }
    }

    while(!q.isEmpty()){
      Tomato now = q.poll();

      int z = now.z;
      int y = now.y;
      int x = now.x;

      for(int d =0 ; d <6 ; d++){
        int nz = z + dz[d];
        int ny = y + dy[d];
        int nx = x + dx[d];

        if(check(nz, ny, nx, tomatos)){
          tomatos[nz][ny][nx] = tomatos[z][y][x] + 1;
          q.add(new Tomato(nz, ny, nx));
        }
      }
    }

    int result = Integer.MIN_VALUE;

    for(int i = 0; i < h; i++){
      for(int j = 0; j < n; j++){
        for(int k = 0; k < m; k++){
          if(tomatos[i][j][k] == 0) {
            System.out.println(-1);
            return;
          }
          result = Math.max(result, tomatos[i][j][k]);
        }
      }
    }
    // 최대 값이 1이라면 원래부터 모두 익어있었음
    if(result == 1){
      System.out.println(0);
      return;
    }
    System.out.println(result-1);
  }
}