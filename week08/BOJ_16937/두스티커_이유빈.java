package BOJ_16937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두스티커_이유빈 {
  static int H, W, n, h, w;
  static int result;
  static int[][] stickers;
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(br.readLine());

    stickers = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      stickers[i][0] = Integer.parseInt(st.nextToken());
      stickers[i][1] = Integer.parseInt(st.nextToken());
    }

    result = 0;
    firstStick();
    System.out.print(result);
  }

  static void firstStick() {
    for (int i=0; i<n; i++) {
      h = stickers[i][0];
      w = stickers[i][1];

      if (h <= H && w <= W) {
        secondSticker(H - h, W - w, i+1, h * w);
      }

      // 90도 회전
      if (h <= W && w <= H) {
        secondSticker(H - w, W - h, i+1, h * w);
      }
    }
  }

  static void secondSticker(int newH, int newW, int idx, int size) {
    for (int i=idx; i<n; i++) {
      h = stickers[i][0];
      w = stickers[i][1];

      if ((h <= newH && w <= W) || (h <= H && w <= newW)) {
        result = Math.max(result, size + h * w);
      }

      // 90도 회전
      if ((w <= newH && h <= W) || (w <= H && h <= newW)) {
        result = Math.max(result, size + h * w);
      }
    }
  }
}
