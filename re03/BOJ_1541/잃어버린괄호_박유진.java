package BOJ_1541;
import java.util.*;
import java.io.*;

public class 잃어버린괄호_박유진 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    if(!str.contains("-")){
      StringTokenizer st = new StringTokenizer(str, "+", false);
      int sum = 0;
      while(st.hasMoreTokens()){
        int num = Integer.parseInt(st.nextToken());
        sum += num;
      }
      System.out.println(sum);
      return;
    }

    StringTokenizer st = new StringTokenizer(str, "-", false);

    int answer = 0;
    boolean isFirstToken = true;

    while(st.hasMoreTokens()){
      StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+", false);

      int sum = 0;
      while(st2.hasMoreTokens()){
        int num = Integer.parseInt(st2.nextToken());
        sum += num;
      }

      if(isFirstToken){
        answer+= sum;
        isFirstToken=false;
        continue;
      }
      answer -= sum;
    }
    System.out.println(answer);
  }
}
