package BOJ_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_이유빈 {

  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] t = new int[n];
    int[] p = new int[n];

    StringTokenizer st;

    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());

      t[i] = Integer.parseInt(st.nextToken());
      p[i] = Integer.parseInt(st.nextToken());
    }

    int[] money = new int[n+1];

    for(int i=0; i<n; i++){
      if(i + t[i] <= n) {
        money[i + t[i]] = Math.max(money[i + t[i]], money[i] + p[i]);
      }

      money[i+1] = Math.max(money[i+1], money[i]);
    }
    System.out.println(money[n]);
  }
}
