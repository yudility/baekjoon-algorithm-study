package BOJ_9934;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 완전이진트리_이유빈 {
  static int k;
  static int[] arr;
  static List<ArrayList<Integer>> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    k = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    arr = new int[(int) Math.pow(2, k) - 1];

    for (int i=0; i<arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    list = new ArrayList<>();
    for (int i=0; i<k; i++) {
      list.add(new ArrayList<>());
    }

    solve(0, arr.length-1, 0);

    for (int i=0; i<k; i++) {
      for (int j : list.get(i)) {
        bw.write(j + " ");
      }
      bw.write("\n");
    }

    br.close();
    bw.flush();
    bw.close();

  }

  static void solve(int start, int end, int depth) {
    if (depth == k) return;
    int mid = (start + end) / 2;

    list.get(depth).add(arr[mid]);
    solve(start, mid-1, depth+1);
    solve(mid+1, end, depth+1);
  }
}
