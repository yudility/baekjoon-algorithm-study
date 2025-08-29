package BOJ_1541;

import java.io.*;

public class 잃어버린괄호_연예림
{
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] minusArr = br.readLine().split("\\-");
    int total = 0;

    for (int i = 0; i < minusArr.length; i++) {

      String[] plusArr = minusArr[i].split("\\+");
      int sum = 0;

      for (int j = 0; j < plusArr.length; j++) {
        sum += Integer.parseInt(plusArr[j]);
      }

      if (i == 0) {
        total += sum;
      } else {
        total -= sum;
      }
    }

    System.out.println(total);
  }
}
