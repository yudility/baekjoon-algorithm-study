package BOJ_6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//30분
public class 애너그램_연예림 {

  static StringBuilder sb;
  static char[] str;
  static boolean[] check;
//  static Set<String> strSet;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {

      str = br.readLine().toCharArray();
      Arrays.sort(str);
      check = new boolean[str.length];

      for (int j = 0; j < str.length; j++) {
        if (j > 0 && str[j] == str[j-1]) {
          continue;
        }

        check[j] = true;
        getResult(1, str[j]+"", str[j]);
        check[j] = false;
      }

    }

    System.out.println(sb);

  }

  private static void getResult(int depth, String result, char last) {
    if (depth == str.length) {
      sb.append(result).append("\n");
      return;
    }

    char pre = '0';
    for (int i = 0; i < str.length; i++) {

      if (check[i]) continue;
      if (str[i] == pre) continue; // 같은 depth 에서 같은 글자일 경우 제외

      check[i] = true;
      getResult(depth + 1, result+str[i], str[i]);
      check[i] = false;
      pre = str[i];
    }

  }

}
