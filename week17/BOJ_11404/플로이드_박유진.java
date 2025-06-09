import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 플로이드_박유진{
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M;
  static int distance[][];

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    distance = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (i == j)
          distance[i][j] = 0;
        else
          distance[i][j] = Integer.MAX_VALUE;
      }
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      if (distance[s][e] > v)
        distance[s][e] = v;
    }
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
          if (distance[i][j] > distance[i][k] + distance[k][j])
            distance[i][j] = distance[i][k] + distance[k][j];
        }
      }
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (distance[i][j] == Integer.MAX_VALUE)
          System.out.print("0 ");
        else
          System.out.print(distance[i][j] + " ");
      }
      System.out.println();
    }
  }
}
