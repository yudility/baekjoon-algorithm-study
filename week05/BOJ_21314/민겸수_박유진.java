package BOJ_21314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 민겸수_박유진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int idx = 0;
        StringBuilder minTodigit = new StringBuilder();

        //최대값 구하기
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                idx += 1;
            } else {
                minTodigit.append(5).append("0".repeat(idx));
                idx = 0;
            }
        }
        if (idx > 0) {
            minTodigit.append("1".repeat(idx));
        }
        minTodigit.append('\n');

        idx = 0;

        //최소값 구하기
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                idx += 1;
            } else {
                if (idx > 0){
                    minTodigit.append(1).append("0".repeat(idx-1)).append(5);
                    idx = 0;
                }
                else{
                    minTodigit.append(5);
                }
            }
        }

        if ( idx >0) {
            minTodigit.append(1).append("0".repeat(idx-1));
        }

        System.out.println(minTodigit);
    }
}