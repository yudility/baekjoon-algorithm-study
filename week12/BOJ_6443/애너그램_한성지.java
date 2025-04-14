package BOJ_6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 애너그램_한성지 {

  static int[] alphabet;
  static int N;   // 단어의 개수
  static String word;   // 단어
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    sb = new StringBuilder();

    for (int i = 0; i < N; i++) {

      word = br.readLine();
      alphabet = new int[26];

      // word의 'a' ~ 'z' 개수 저장
      for (int j = 0; j < word.length(); j++) {
        alphabet[word.charAt(j) - 'a']++;
      }

      dfs(0, new StringBuilder(), word.length());
    }

    System.out.println(sb);
  }

  public static void dfs(int depth, StringBuilder current, int length) {
    
    if (depth == length) {
      sb.append(current).append("\n");
      return;
    }

    // 알파벳 a부터 시작하기 때문에 자동으로 사전순 정렬됨
    for (int i = 0; i < 26; i++) {
      if (alphabet[i] > 0) {
        alphabet[i]--;
        current.append((char) (i + 'a'));
        
        dfs(depth + 1, current, length);
        
        // 백트래킹
        // 재귀 호출이 끝난 뒤, 그 전에 붙였던 문자를 제거해 다른 경우의 수를 탐색할 수 있도록 함
        current.deleteCharAt(current.length() - 1);
        alphabet[i]++;  // 개수 원상복귀
      }
    }
  }
}