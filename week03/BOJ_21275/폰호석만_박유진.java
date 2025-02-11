package BOJ_21275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 폰호석만_박유진 {

    static long x, a, b;
    static int cnt;
    static Map<String, Integer> nums;
    static double max = Math.pow(2, 63);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //진법 변환을 위해 각 수를 mapping 할 map
        nums = new HashMap<>();

        for (int i = 1; i <= 36; i++) {
            if (i < 10) {
                nums.put(Integer.toString(i), i);
                continue;
            }
            nums.put( Character.toString(97 + (i - 10)), i);
        }

        st = new StringTokenizer(br.readLine());

        String strA = st.nextToken(); //a진법 x
        String strB = st.nextToken(); //b진법 x

        if(strA.equals("0") || strB.equals("0")) {
            System.out.println("Multiple");
            return;
        }

        for (int i = 1; i <= 36; i++) {
            for (int j = 1; j <= 36; j++) {
                //같은 경우 pass
                if (i == j) continue;

                //진법 변환
                long ax = getX(strA, i);
                long bx = getX(strB, j);

                if (ax == -1 || bx == -1 || ax > max ) continue;
                if (ax == bx) {
                    cnt++;
                    if(cnt > 1) break;
                    x = ax;
                    a = i;
                    b = j;
                }
            }
            if (cnt > 1) {
                break;
            }
        }

        if (cnt > 1) {
            System.out.println("Multiple");
        } else if (cnt == 1) {
            System.out.println(x + " " + a + " " + b);
        } else {
            System.out.println("Impossible");
        }
    }

    public static long getX(String str, int g) {
        int length = str.length();
        long x = 0;

        // 각 자릿수별로 계산
        for (int i = 0; i < length; i++) {
            char current = str.charAt(i);
            // 현재 문자에 해당하는 숫자가 없거나 진법보다 크면 유효하지 않은 수
            String currentChar = Character.toString(current);
            if (!nums.containsKey(currentChar)) return -1;

            int currentNum = nums.get(currentChar);
            if (currentNum >= g) return -1;

            // x = x * g + currentNum
            x = x * g + currentNum;

            // 오버플로우 체크
            if (x > max) return -1;
        }

        return x;
    }

    public static int getNum(char c, int place, int now, int gin) {
        if (now == place ) {
            return nums.get(Character.toString(c));
        }
        return getNum(c, place, now + 1, gin) * gin;
    }

}
