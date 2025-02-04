package BOJ_1620;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_김준우 {
    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> stringKey = new HashMap<>();
        Map<Integer, String> integerKey = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            stringKey.put(input, i);
            integerKey.put(i, input);
        }
        while (m-- > 0) {
            String input = br.readLine();
            if (!isInteger(input)) { // 문자열이 주어질 때
                sb.append(stringKey.get(input) + "\n");
            } else { // 숫자가 주어질 때
                sb.append(integerKey.get(Integer.parseInt(input)) + "\n");
            }
        }
        br.close();
        System.out.println(sb);
    }
}
