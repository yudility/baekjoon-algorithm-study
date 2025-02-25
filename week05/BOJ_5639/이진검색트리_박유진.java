package BOJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리_박유진 {

  static StringBuilder sb;

  static class Node_y {

    int data;
    Node_y leftChild, rightChild;

    public Node_y(int data) {
      this.data = data;
      this.leftChild = null;
      this.rightChild = null;
    }

    //노드 자체에 이진 검색 트리 insert 구현
    void insert(int data) {
      if(data < this.data){ //지금 노드보다 작은 수이고
        if(this.leftChild == null) this.leftChild = new Node_y(data); //왼쪽 자식 노드가 비어있다면 삽입
        else this.leftChild.insert(data); //비어있지 않다면 재귀적으로 왼쪽 자식의 Insert 호출
      }else{//지금 노드보다 큰 수이고
        if(this.rightChild == null) this.rightChild = new Node_y(data);//오른쪽 자식 노드가 비어있다면 삽입
        else this.rightChild.insert(data); //비어있지 않다면 재귀적으로 오른쪽 자식의 Insert 호출
      }
    }
  }

  //후위순회
  static void postOrder(Node_y now) {
    if (now == null)
      return;

    postOrder(now.leftChild);
    postOrder(now.rightChild);
    sb.append(now.data).append(" ");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    Node_y root = new Node_y(Integer.parseInt(br.readLine()));

    String line;
    while(true){
      line = br.readLine();
      if(line==null ||line.isEmpty() ) break;
      root.insert(Integer.parseInt(line));
    }

    postOrder(root);
    System.out.println(sb);
  }

}
