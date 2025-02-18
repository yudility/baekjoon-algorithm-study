package BOJ_21314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 민겸수_한성지 {

    static String[] answer = {"", ""};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // (?<=K) : K 기준으로 뒤를 자름 - MK/M
        // (?=K) : K 기준으로 앞을 자름 - M/KM
        // 최대값의 경우 문자열을 최소한으로 잘라주면 되므로 K의 뒤를 자름
        String[] tokensMax = str.split("(?<=K)");
        changeMax(0, tokensMax);

        // 최소값의 경우 K는 분리, M끼리는 붙여야 하므로 K의 앞뒤를 다 잘라줌
        String[] tokensMin = str.split("(?<=K)|(?=K)");
        changeMin(1, tokensMin);

        System.out.println(answer[0] + "\n" + answer[1]);
    }
    
    // 최대값
    static void changeMax(int index, String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].contains("K")) {
                int m = tokens[i].split("").length - 1; // M 개수

                answer[index] += "5";
                for (int j = 0; j < m; j++) {
                    answer[index] += "0";
                }
            } else {
                int m = tokens[i].split("").length; // M 개수

                for (int j = 0; j < m; j++) {
                    // 최대값의 경우 M만 있을 때는 무조건 1 반환
                    answer[index] += "1";
                }
            }
        }
    }

    // 최소값
    static void changeMin(int index, String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].contains("K")) {
                int m = tokens[i].split("").length - 1; // M 개수

                answer[index] += "5";
                for (int j = 0; j < m; j++) {
                    answer[index] += "0";
                }
            } else {
                int m = tokens[i].split("").length; // M 개수

                // 최소값인 경우 M만 있을 때 10^(m 개수-1)로 반환
                answer[index] += "1";
                for (int j = 0; j < m - 1; j++) {
                    answer[index] += "0";
                }
            }
        }
    }
}