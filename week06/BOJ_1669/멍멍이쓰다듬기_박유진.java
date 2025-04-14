package BOJ_1669;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멍멍이쓰다듬기_박유진 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long x = Long.parseLong(st.nextToken());
    long y = Long.parseLong(st.nextToken());

    long sub = y-x;

    if(sub == 0 ){
      System.out.println(0);
    }
    else{
      long sqrt = (long) Math.sqrt(sub);
      long pow = sqrt * sqrt;
      if(sub == pow){
        System.out.println( 2* sqrt - 1);
      }else{
        sub = sub - pow;
        if( sub <= sqrt ){
          System.out.println(2*sqrt);
        }else{
          System.out.println(2*sqrt+1);
        }
      }
    }
  }
}
