package BOJ_16937;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Sticker {
  int r;
  int c;
  int mul;

  public Sticker(int r, int c) {
    this.r = r;
    this.c = c;
    this.mul = r * c;
  }
}

public class 두스티커_연예림 {

  static int h;
  static int w;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 넓이
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    // 스티커
    List<Sticker> stickers = new ArrayList<>();

    // 스티커 개수
    int n = Integer.parseInt(br.readLine());

    // 각 스티커의 넓이
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (valid(r, c)) { // 스티커가 모눈 종이 크기를 넘지 않는지 확인
        stickers.add(new Sticker(r, c));
      }
    }

    // 여러 개의 스티커 중 두 스티커를 골라붙였을 때, 최대 넓이
    int max = 0;
    for (int i = 0; i < stickers.size()-1; i++) {
      for (int j = i+1; j < stickers.size(); j++) {

        // 첫 번째 스티커 부착 후 두 번째 스티커가 규격에 맞는지 확인
        if(checkSize(stickers.get(i), stickers.get(j))) {
          int extent = stickers.get(i).mul + stickers.get(j).mul;

          if (extent > max) {
            max = extent;
          }
        }
      }
    }

    // 두 스티커를 붙일 수 없는 경우는 0 출력
    System.out.println(max);
  }

  public static boolean checkSize(Sticker first, Sticker second) {
    int[][] spaces = {                  //[2]: 회전 후 규격에 맞는지 확인
        {h - first.r, w, w - first.c}, // (h - r, w): 첫 번째 스티커의 부착 후 아래 공간 크기 (남은 row)
        {w - first.c, h, h - first.r}, // (w - c, h): 첫 번째 스티커의 부착 후 오른쪽 공간 크기 (남은 col)
        {h - first.c, w, w - first.r}, // (h - c, w): 첫 번째 스티커(회전)의 부착 후 아래 공간 크기 (남은 row)
        {w - first.r, h, h - first.c}, // (w - r, h): 첫 번째 스티커(회전)의 부착 후 오른쪽 공간 크기 (남은 col)
    };

    for (int[] space : spaces) { // 두 번째 스티커가 남은 공간에 맞는지 확인

      if (space[0] > 0 && space[2] >= 0 && ((second.r <= space[0] && second.c <= space[1])
          || (second.r <= space[1] && second.c <= space[0]))) {

        return true;

      }
    }
    return false;
  }

  public static boolean valid(int r, int c) {
    return (r <= h && c <= w) || (c <= h && r <= w);
  }
}
