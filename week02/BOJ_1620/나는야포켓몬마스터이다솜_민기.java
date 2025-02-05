package BOJ_1620;

import java.util.*;
import java.io.*;

public class 나는야포켓몬마스터이다솜_민기 {
    static Map<Integer, String> numberToName = new HashMap<>(); // 포켓몬 번호 -> 이름
    static Map<String, Integer> nameToNumber = new HashMap<>(); // 포켓몬 이름 -> 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //포켓몬 도감 저장은 hashmap으로..?
        for (int i = 1; i < n+1; i++) {
            String str = br.readLine();
            numberToName.put(i, str);
            nameToNumber.put(str, i);
        }

        //문제를 받은 다음 hashmap에서 찾는다
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            String str = br.readLine().trim();
            if (Character.isDigit(str.charAt(0))) {
                int index = Integer.parseInt(str);
                sb.append(numberToName.get(index)).append("\n");
            } else {
                sb.append(nameToNumber.get(str)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}