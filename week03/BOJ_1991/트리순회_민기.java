package BOJ_1991;

import java.util.*;
import java.io.*;

class Node{
	char value;
	Node left;
	Node right;
	public Node(char value) {
		this.value = value;
	}
}
public class 트리순회_민기 {
	static Map<Character, Node> tree = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());

			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			tree.putIfAbsent(parent, new Node(parent));

			Node parentNode = tree.get(parent);

			if (left != '.') {
				parentNode.left = new Node(left);
				tree.put(left,parentNode);
			}

			if(right != '.') {
				parentNode.right = new Node(right);
				tree.put(right,parentNode);
			}
		}

		//순회 결과 저장
		StringBuilder preOrder = new StringBuilder();
		StringBuilder inOrder = new StringBuilder();
		StringBuilder postOrder = new StringBuilder();

		//각각 순회 저장
		preOrder(tree.get('A'), preOrder);
		inOrder(tree.get('A'), inOrder);
		postOrder(tree.get('A'), postOrder);

		//결과 출력
		System.out.println(preOrder);
		System.out.println(inOrder);
		System.out.println(postOrder);
	}

	// 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
	static void preOrder(Node node, StringBuilder result) {
		if (node == null) return;
		result.append(node.value);
		preOrder(node.left, result);
		preOrder(node.right, result);
	}

	// 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
	static void inOrder(Node node, StringBuilder result) {
		if (node == null) return;
		inOrder(node.left, result);
		result.append(node.value);
		inOrder(node.right, result);
	}

	// 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
	static void postOrder(Node node, StringBuilder result) {
		if (node == null) return;
		postOrder(node.left, result);
		postOrder(node.right, result);
		result.append(node.value);
	}
}
