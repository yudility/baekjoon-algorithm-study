package BOJ_1011;

import java.io.*;
import java.util.*;

public class Flyme_연예림  {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    for(int i = 0; i< t; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      System.out.println(calMin(x, y));
    }

  }

  static int calMin(int x, int y) {
    int dist = y - x;
    int sqrt = (int) Math.sqrt(dist);

    int answer = 0;
    if(sqrt == Math.sqrt(dist)) {
      answer = sqrt * 2 - 1;
    }else if(dist <= (sqrt * sqrt + sqrt)) {
      answer = sqrt * 2;
    }else {
      answer = sqrt * 2 + 1;
    }

    return answer;
  }
}