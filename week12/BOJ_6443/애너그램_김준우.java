package BOJ_6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 애너그램_김준우 {

  static int N;
  static Map<Integer, char[]> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      char[] charArray = s.toCharArray();
      Arrays.sort(charArray);
      map.put(i, charArray);
    }

    for (int i = 0; i < N; i++) {
      char[] arr = map.get(i);
      boolean[] visited = new boolean[arr.length];
      List<String> result = new ArrayList<>();

      dfs(arr, visited, "", 0, result);

      for (String s : result) {
        System.out.println(s);
      }
    }
  }

  /*
  * arr : 애너그램을 만들 대상 문자 배열
  * visited : 각 문자가 사용되었는지 표시
  * path : 현재까지 만든 문자열
  * depth : 현재 문자열의 길이
  * result : 완성된 애너그램들을 저장하는 리스트
  *
   */
  static void dfs(char[] arr, boolean[] visited, String path, int depth, List<String> result) {
    if (depth == arr.length) {
      result.add(path);
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (visited[i]) {
        continue;
      }

      // 중복된 문자가 연속으로 있을 때 중복 순열 방지
      // 이전 문자와 같은 문자이고 아직 이전 문자가 선택되어 있지 않은 경우에는 건너뛰기
      if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
        continue;
      }

      visited[i] = true;
      dfs(arr, visited, path + arr[i], depth + 1, result);
      // 다른 경로에서 문자를 다시 사용할 수 있도록 방문 표시를 해제해야 한다!
      visited[i] = false;
    }
  }
}
