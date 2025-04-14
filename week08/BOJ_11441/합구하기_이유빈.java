package BOJ_11441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합구하기_이유빈 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());

    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());

    int[] prefix = new int[n+1];
    prefix[0] = 0;
    for (int i=1; i<=n; i++) {
      prefix[i] = prefix[i-1] + arr[i-1];
    }

    for (int i=1; i<=m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(prefix[b] - prefix[a-1]);
    }
  }
}
