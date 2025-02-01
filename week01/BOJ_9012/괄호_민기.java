package BOJ_9012;

import java.util.*;
import java.io.*;

public class 괄호_민기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            String line = br.readLine();
            int count =0;
            boolean isValid = true;

            //문자열의 각 문자를 순회하면서 검사
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == '(') {
                    count++;
                } else if (ch == ')') {
                    count--;

                    //닫는 괄호 처리시 count가 음수가 되면 유효하지 않음
                    if(count<0){
                        isValid = false;
                        break;
                    }
                }
            }

            //문자열 전체 순회 후에도 count가 0이 아니라면 괄호 문자열이 아님
            if (count != 0) {
                isValid = false;
            }
            sb.append(isValid ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
