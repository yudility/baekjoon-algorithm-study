package BOJ_1158;
import java.io.*;
import java.util.*;

public class 요세푸스문제_민기 {

    public static void main(String[] args) throws IOException {
        //bufferedReader로 입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i =1;i<=n;i++){
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!queue.isEmpty()){
            for (int i = 0; i < k -1 ; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
