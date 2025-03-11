package BOJ_20438;

import java.util.*;
import java.io.*;

public class 출석체크_박유진 {
    
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    boolean[] checked = new boolean[n+3];
    boolean[] slept = new boolean[n+3];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < k; i++){
      int num = Integer.parseInt(st.nextToken());
      slept[num]=true;
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < q; i++){
      int num = Integer.parseInt(st.nextToken());
      if(slept[num]){
        continue;
      }
      for(int j=1; (num*j)<=n+2; j++){
        if(slept[num*j]){
          continue;
        }
        checked[num*j] =true;
      }
    }


    for(int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      int result = 0;

      for(int j = s; j<= e; j++){
        if(!checked[j]){
          result++;
        }
      }
      sb.append(result).append("\n");
    }

    System.out.println(sb);

  }
}

