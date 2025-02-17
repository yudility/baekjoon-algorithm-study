package BOJ_21314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 30분
public class 민겸수_연예림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 최댓값, 최솟값
        System.out.println(getMax(input));
        System.out.println(getMin(input));
    }

    public static String getMax(String str) {
        // k를 기준으로 가장 크게 묶는 경우
        // k가 나올때까지 m count -> k가 나오면 5를 넣고 m count 만큼 0추가
        StringBuffer sb = new StringBuffer();
        int mCnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'M') {
                mCnt++;
            } else if (str.charAt(i) == 'K'){
                sb.append("5").append("0".repeat(mCnt));
                mCnt = 0;
            }
        }
        // 단, 마지막 묶음이 k가 없는 경우 모두 m(1) 으로 처리한다.
        if (mCnt != 0) {
            sb.append("1".repeat(mCnt));
        }
        return sb.toString();
    }

    public static String getMin(String str) {
        // M 과 K를 모두 분리하되 M은 붙어있을때 같은 묶음으로 처리한다.
        // k가 나올때까지 m count -> k가 나오면 5를 넣고 m count 만큼 0추가
        StringBuffer sb = new StringBuffer();
        int mCnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'M') {
                mCnt++;
            } else if (str.charAt(i) == 'K'){
                if (mCnt > 0) {
                    sb.append("1").append("0".repeat(mCnt-1));
                    mCnt = 0;
                }
                sb.append(5);
            }
        }
        if (mCnt > 0) {
            sb.append(1).append("0".repeat(mCnt-1));
        }
        return sb.toString();
    }
}
