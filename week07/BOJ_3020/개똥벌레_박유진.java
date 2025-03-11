package BOJ_3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개똥벌레_박유진 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    int[][] acc = new int[h][n+1];


    for(int i=0; i<h; i++){
      acc[i][0] = 0;
    }

    for(int i=1; i<n+1 ; i++ ){

      int a = Integer.parseInt(br.readLine());
      //i 홀수일때는 석순
      if(i%2 !=0){
        for(int j=0; j<h; j++){
          if( j<a ){
            acc[h-1-j][i] = acc[h-1-j][i-1]+1;
          }else{
            acc[h-1-j][i] = acc[h-1-j][i-1];
          }
        }
      }else{
        //i 짝수일때는 종유석
        for(int j=0; j<h; j++){
          if(j+1<=a){
            acc[j][i] = acc[j][i-1]+1;
          }else{
            acc[j][i] = acc[j][i-1];
          }
        }
      }
    }

    int minVal = 200001;
    for(int i=0; i<h; i++){
      minVal = Math.min(acc[i][n], minVal);
    }

    int ranges = 0;
    for(int i=0; i<h; i++){
      if(acc[i][n] == minVal){
        ranges++;
      }
    }

    sb.append(minVal).append(" ").append(ranges).append("\n");

    System.out.println(sb);
  }
}
