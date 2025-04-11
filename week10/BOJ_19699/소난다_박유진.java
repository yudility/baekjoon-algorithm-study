package BOJ_19699;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class 소난다_박유진
{
  static int n, m;
  static Set<Integer> primes;
  static Set<Integer> answer = new TreeSet<>();


  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int[] cows = new int[n];
    boolean[] visited = new boolean[n];

    st = new StringTokenizer(br.readLine());

    for(int i=0; i<n; i++){
      cows[i] = Integer.parseInt(st.nextToken());
    }

    int total = Arrays.stream(cows).sum();

    primes = getPrimes(total);

    solu(0, 0, 0, cows, visited);

    List<Integer> result = answer.stream().collect(Collectors.toUnmodifiableList());

    if(result.isEmpty()){
      System.out.println(-1);
      return;
    }

    for (int i=0; i<result.size(); i++){
      sb.append(result.get(i)).append(" ");
    }

    System.out.println(sb);


  }

  public static void solu(int nowIdx,int cnt, int weight, int[] cows, boolean[] visited){

    if(cnt == m){
      if(primes.contains(weight)){
        answer.add(weight);
      }
      return;
    }

    for(int i = nowIdx; i<n; i++){
      visited[i]=true;
      weight += cows[i];

      solu(i+1, cnt+1, weight, cows, visited);

      visited[i]=false;
      weight -= cows[i];

    }

  }

  public static Set<Integer> getPrimes(int total){

    Set<Integer> primes = new TreeSet<>();
    for(int i = 2; i <= total; i++) {
      boolean isPrimeNumber = true;

      for(int j = 2; j <= Math.sqrt(i); j++) {
        if(i%j == 0) {
          isPrimeNumber = false;
          break;
        }
      }
      if(isPrimeNumber) {
        primes.add(i);
      }
    }


    return primes;
  }
}
