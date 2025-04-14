package BOJ_2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 오목_연예림_복습 {

  static List<List<Integer>> pan;
  static int size = 19;
  static int[] dCol = {1, 1, 1, 0};
  static int[] dRow = {1, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 입력
    pan = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      List<Integer> row = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(
          Collectors.toList());
      pan.add(row);
    }

    boolean flag = false;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size;j++) {
        if (pan.get(i).get(j) != 0 && check(i, j)) {
          sb.append(pan.get(i).get(j)).append("\n");
          sb.append(i+1).append(" ").append(j+1);
          flag = true;
          break;
        }
      }
      if(flag) {
        break;
      }
    }

    if(flag) {
      System.out.println(sb);
    } else {
      System.out.println(0);
    }
  }

  public static boolean check(int row, int col) {
    int turn = pan.get(row).get(col);

    // 네 방향으로 체크
    for (int i = 0; i < dRow.length; i++) {
      // 5개인지 체크
      int cRow = row;
      int cCol = col;
      int cnt = 0;

      while (checkRange(cRow) && checkRange(cCol) && pan.get(cRow).get(cCol) == turn) {
        cnt++;
        cRow += dRow[i];
        cCol += dCol[i];
      }

      if (cnt == 5) {
        // 범위 벗어나거나 다르면
        if ( !checkRange(row - dRow[i]) || !checkRange(col - dCol[i]) || pan.get(row - dRow[i]).get(col - dCol[i]) != turn) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean checkRange(int n) {
    return n >= 0 && n < size; //0~18
  }
}
