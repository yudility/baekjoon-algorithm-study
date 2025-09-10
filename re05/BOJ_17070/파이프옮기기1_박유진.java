package BOJ_17070;

import java.util.*;
import java.io.*;

public class 파이프옮기기1_박유진
{
    static int n;
    static int[][] map = new int[20][20];
    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 0, 1};
    static int count = 0;

    static void dfs(int y, int x, int dir){

        if(y == n-1 && x == n-1 ){
            count++;
            return;
        }

        for(int d = 0; d < 3 ; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            if( ny < 0 || nx < 0 || ny >= n || nx >= n ) continue; // 범위 밖 불가
            if( map[ny][nx] == 1 ) continue; // 벽 이동 불가
            if( (dir == 0 && d == 1)  || (dir == 1 && d == 0)) continue; // 가로 -> 세로 이동 불가, 세로 -> 가로 이동 불가
            if( d == 2 && ( map[ny-1][nx] == 1 || map[ny][nx - 1] == 1 )) continue;//대각선일 때 회전할 공간이 벽이면 긁으므로 불가

            dfs(ny, nx, d);
        }
    }

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    n = Integer.parseInt(br.readLine());

	    for(int i = 0; i<n; i++){
	        st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
	    }

	    dfs(0, 1, 0); // 1,2 부터 가로방향으로 시작

		System.out.println(count);
	}
}
