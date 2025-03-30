package BOJ_16937;

import java.util.*;
import java.io.*;

public class 두스티커_박유진 {

  static class StickerYu {
    int h, w;

    public StickerYu(int h, int w) {
      this.h = h;
      this.w = w;
    }
  }
  static int H, W, N;
  static int ans = 0;
  static StickerYu[] stickerYus;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(br.readLine());
    stickerYus = new StickerYu[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      stickerYus[i] = new StickerYu(h, w);
    }
    firstSticker();
    System.out.println(ans);
  }

  // 스티커 1개 붙이기
  public static void firstSticker() {
    for (int i = 0; i < N; i++) {
      StickerYu stickerYu = stickerYus[i];
      int h = stickerYu.h, w = stickerYu.w;
      // 원래 모양대로 붙이기
      if (h <= H && w <= W) { // 해당 스티커를 붙일 수 있는 경우
        secondSticker(H - h, W - w, i + 1, h * w);
      }

      // 90도 회전해서 붙이기
      if (h <= W && w <= H) { // 해당 스티커를 붙일 수 있는 경우
        secondSticker(H - w, W - h, i + 1, h * w);
      }
    }
  }

  // 스티커 2개 붙이기
  public static void secondSticker(int newH, int newW, int idx, int size) {
    for (int i = idx; i < N; i++) {
      StickerYu stickerYu = stickerYus[i];
      int h = stickerYu.h, w = stickerYu.w;
      // 원래 모양대로 붙이기
      if ((h <= newH && w <= W) || (h <= H && w <= newW)) {
        ans = Math.max(ans, size + h * w);
      }

      // 90도 회전해서 붙이기
      h = stickerYu.w;
      w = stickerYu.h;
      if ((h <= newH && w <= W) || (h <= H && w <= newW)) {
        ans = Math.max(ans, size + h * w);
      }
    }
  }

}