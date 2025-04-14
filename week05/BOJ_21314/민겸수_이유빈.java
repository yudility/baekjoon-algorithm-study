package BOJ_21314;

import java.io.*;

public class 민겸수_이유빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String max = "";
        String min = "";
        String subMax = "";
        String subMin = "";

        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == 'M') {
                subMin += "1";
                subMax += "1";
            } else if (input.charAt(i) == 'K') {
                if (subMin.length() > 0) {
                    min += "1";
                    for (int j=0; j<subMin.length()-1; j++) {
                        min += "0";
                    }
                    subMin = "";
                }
                min += "5";
                max += "5";

                for (int j=0; j<subMax.length(); j++) {
                    max += "0";
                }
                subMax = "";
            }
        }
        if (!subMax.equals("")) {
            for (int i=0; i<subMax.length(); i++) {
                max += "1";
            }
        }
        if (!subMin.equals("")) {
            min += "1";
            for (int i=0; i<subMin.length()-1; i++) {
                min += "0";
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
