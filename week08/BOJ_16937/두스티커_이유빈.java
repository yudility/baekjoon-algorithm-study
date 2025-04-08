package BOJ_16937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두스티커_이유빈 {
  static int H, W, n;
  static int result = 0;
  static Sticker[] stickers;
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(br.readLine());

    stickers = new Sticker[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      stickers[i] = new Sticker(h, w);
    }

    firstStick();
    System.out.println(result);
  }

  static void firstStick() {
    for (int i=0; i<n; i++) {
      Sticker sticker = stickers[i];
      int h = sticker.h, w = sticker.w;

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
    for (int i = idx; i < n; i++) {
      Sticker sticker = stickers[i];
      int h = sticker.h, w = sticker.w;

      if ((h <= newH && w <= W) || (h <= H && w <= newW)) {
        result = Math.max(result, size + h * w);
      }

      // 90도 회전
      h = sticker.w;
      w = sticker.h;
      if ((h <= newH && w <= W) || (h <= H && w <= newW)) {
        result = Math.max(result, size + h * w);
      }
    }
  }

  static class Sticker {
    int h, w;

    public Sticker(int h, int w) {
      this.h = h;
      this.w = w;
    }
  }
}
