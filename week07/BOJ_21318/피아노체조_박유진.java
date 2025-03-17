package BOJ_21318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피아노체조_박유진 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] ak = new int[n];
    int[] miss = new int[n];

    st = new StringTokenizer(br.readLine());
    miss[0] = 0;

    for(int i=0; i<n; i++){
      ak[i] = Integer.parseInt(st.nextToken());
      if( i > 0 && ak[i-1] > ak[i] ){
        miss[i]= miss[i-1] +1;
      }else if(i>0){
        miss[i] = miss[i-1];
      }
    }

    int q = Integer.parseInt(br.readLine());
    for(int i=0; i<q; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      sb.append(miss[y-1] - miss[x-1]).append("\n");
    }

    System.out.println(sb);
  }
}
