import java.util.*;

class BOJ_1043_김준우 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    boolean[] knowTrue = new boolean[n + 1];

    int num = sc.nextInt();
    for(int i = 0; i < num; i++) {
      int x = sc.nextInt();
      knowTrue[x] = true;
    }

    List<int[]> parties = new ArrayList<>(m);
    for(int i = 0; i < m; i++) {
      int k = sc.nextInt();
      int[] attend = new int[k];
      for(int j = 0; j < k; j++) {
        attend[j] = sc.nextInt();
      }
      parties.add(attend);
    }

    boolean changed = true;

    while(changed) {
      changed = false;
      for(int[] party : parties) {
        boolean hasTruth = false;

        for(int p : party) {
          if (knowTrue[p]) {
            hasTruth = true;
            break;
          }
        }

        if (hasTruth) {
          for(int p : party) {
            if (!knowTrue[p]) {
              knowTrue[p] = true;
              changed = true;
            }
          }
        }
      }
    }

    int answer = 0;
    for(int[] party : parties) {
      boolean hasTruth = false;
      for(int p : party) {
        if (knowTrue[p]) {
          hasTruth = true;
          break;
        }
      }

      if (!hasTruth) {
        answer++;
      }
    }

    System.out.println(answer);
  }
}