package BOJ_21278;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 호석이두마리치킨_박유진_복습 {

  public static int disSum = Integer.MAX_VALUE;
  public static int[] result = new int[2];
  public static int N, M;
  public static ArrayList<Integer>[] graph;
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 플로이드 워셜
    int dis[][] = new int[N+1][N+1];

    for(int i=0; i<dis.length; i++){
      Arrays.fill(dis[i], 100001);
      dis[i][i] = 0;
    }

    // 간선 입력받기
    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      dis[v1][v2] = 1;
      dis[v2][v1] = 1;
    }

    for(int k=1; k<=N; k++){
      for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
          dis[i][j] = Math.min(dis[i][k] + dis[k][j], dis[i][j]);
        }
      }
    }


    for(int i=1; i<= N-1; i++){
      for(int j=i+1; j<=N; j++){
        int temp = 0;
        for(int k=1; k<=N; k++){
          temp += Math.min(dis[i][k], dis[j][k]);
        }

        if(disSum > temp){
          result[0] = i;
          result[1] = j;
          disSum = temp;
        }
      }
    }
    bw.write(result[0]+" " + result[1]+" ");
    bw.write(disSum*2 + "");
    bw.flush();
  }

}