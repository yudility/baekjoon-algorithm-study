package BOJ_21919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 소수최소공배수_박유진 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    Set<Integer> set = new HashSet<>(); //입력받은 원소를 순서대로 중복제거하여 저장할 Set
    int max = 0; // 입력받은 중 가장 큰 수

    for (int i = 0; i < n; i++) {
      int e = Integer.parseInt(st.nextToken());
      set.add(e);
      max = Math.max(max, e);
    }

    BigInteger result = new BigInteger(String.valueOf(1));

    boolean[] isNotPrime = new boolean[max + 1];

    for(int i=2; i*i<=max; i++){
      if(!isNotPrime[i]){
        for(int j=i*i; j<=max; j+=i){
          isNotPrime[j] = true;
        }
      }
    }

    for(int e : set){
      if(!isNotPrime[e]){
        result = result.multiply(BigInteger.valueOf(e));
      }
    }

    if(result.equals(BigInteger.valueOf(1))){
      System.out.println(-1);
    }else{
      System.out.println(result);
    }
  }
}
