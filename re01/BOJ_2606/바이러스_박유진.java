import java.util.*;
import java.io.*;

public class 바이러스_박유진
{
	public static void main(String[] args) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    int n = Integer.parseInt(br.readLine());
	    int v = Integer.parseInt(br.readLine());

	    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	    int[] visited = new int[n];

	    for (int i = 0 ; i < n ; i++){
		    visited[i] = 0;
	    }

	    for (int i = 0 ; i < n ; i++){
	        list.add(new ArrayList<>());
	    }

	    for(int i = 0; i < v; i++){
	       st = new StringTokenizer(br.readLine());
	       int a = Integer.parseInt(st.nextToken());
	       int b = Integer.parseInt(st.nextToken());
	       list.get(a-1).add(b-1);
	       list.get(b-1).add(a-1);
	   }

	   int answer = 0;

	   Queue<Integer> q = new LinkedList<>();

	   q.add(0);
	   visited[0] = 1;

	   while(!q.isEmpty()){
	       int now = q.poll();

	       for(int node : list.get(now)){
			       if(visited[node] != 1){
			         q.add(node);
		           visited[node] = 1;
		           answer++;
			       }
	       }
	   }
	   System.out.println(answer);
	}
}