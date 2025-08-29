package BOJ_1011;
import java.util.*;
import java.io.*;

public class flyme_박유진 {
  static int T;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());

    for(int i=0; i<T; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int distance = y - x;
      int max = (int)Math.sqrt(distance); // 최고 속도, 소수점 버림
      int count;

      if( Math.sqrt(distance) == max){
        count = 2 * max - 1 ;
      }else if( distance <= max*max +max ){
        count = 2 * max;
      }else{
        count = 2* max + 1;
      }
      bw.write(count + "\n");
    }

    bw.flush();
    bw.close();
  }
}
