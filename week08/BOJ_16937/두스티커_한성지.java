package BOJ_16937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 두스티커_한성지 {

  // 스티커 정보 저장 클래스
  static class Sticker {

    int h;
    int w;

    public Sticker(int h, int w) {
      this.h = h;
      this.w = w;
    }
  }

  static int H; // 모눈종이 크기 - 높이
  static int W; // 모눈종이 크기 - 너비
  static int N; // 스티커 수
  static List<Sticker> stickers;  // 스티커 정보 저장
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    answer = 0;
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(br.readLine());
    stickers = new ArrayList<>();

    // 입력된 스티커 정보 저장
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      // 스티커 크기
      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      // 모눈종이에 붙이지 못하는 경우 넘김(회전한 경우 포함)
      if ((h > H && h > W) || (w > W && w > H)) {
        continue;
      }

      stickers.add(new Sticker(h, w));
    }

    cal();
    System.out.println(answer);
  }

  // 모든 스티커 붙이는 경우 구하는 메서드
  static void cal() {
    // 첫번째 스티커를 (0,0) 기준으로 붙임
    for (int i = 0; i < stickers.size(); i++) {
      Sticker cur = stickers.get(i);
      int size = cur.h * cur.w;   // 스티커 넓이

      int tempH = H - cur.h;    // 스티커 붙이고 남는 높이
      int tempW = W - cur.w;    // 스티커 붙이고 남는 너비
      if (tempH >= 0 && tempW >= 0) { // 첫번째 스티커 붙이기 성공한 경우
        secondSticker(i, tempH, tempW, size);
      }
      
      // 스티커 회전해서 붙여보기
      tempH = H - cur.w;
      tempW = W - cur.h;
      if (tempH >= 0 && tempW >= 0) {
        secondSticker(i, tempH, tempW, size);
      }
    }
  }

  // 두번째 스티커 붙이는 메서드
  static void secondSticker(int index, int h, int w, int size) {

    int secondSize = 0;

    for (int i = index + 1; i < stickers.size(); i++) {
      Sticker cur = stickers.get(i);
      int tempSize = cur.h * cur.w;   // 스티커 넓이
      
      // 스티커 붙일 수 있는지 확인
      if ((cur.h <= h && cur.w <= W)        // 첫번째 스티커 아래에 붙이는 경우
          || (cur.h <= H && cur.w <= w)      // 오른쪽에 붙이는 경우
          || (cur.w <= h && cur.h <= W)     // 회전해서 아래에 붙이는 경우
          || (cur.w <= H && cur.h <= w)) {  // 회전해서 오른쪽에 붙이는 경우
        secondSize = tempSize;
      }

      if (secondSize != 0) {
        answer = Math.max(answer, size + secondSize);
      }
    }
  }
}