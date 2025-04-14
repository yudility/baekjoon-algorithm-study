package BOJ_3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개똥벌레_이유빈 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    int[] line = new int[h];

    for (int i = 0; i < n; i++) {
      int height = Integer.parseInt(br.readLine());

      if (i % 2 == 0) {
        line[0] += 1;
        line[height] -= 1;
      }
      if (i % 2 == 1) {
        line[h - height] += 1;
      }
    }

    int[] prefix = new int[h + 1];
    int min = Integer.MAX_VALUE;
    int num = 0;

    for (int j = 0; j < h; j++) {
      prefix[j + 1] = prefix[j] + line[j];
    }

    for (int k = 1; k <= h; k++) {
      if (min > prefix[k]) {
        min = prefix[k];
        num = 1;
      } else if (min == prefix[k]) {
        num++;
      }
    }

    System.out.println(min + " " + num);

  }

}