// 한 정점으로 부터 모든 정점으로까지의 최단거리
import java.util.*;

public class 벨만포드_연예림 {

    // 그래프의 간선을 표현하는 클래스
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // 그래프 클래스
    static class Graph {
        int vertices;
        List<Edge> edges;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.edges = new ArrayList<>();
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            edges.add(edge);
        }
    }

    // 벨만 포드 알고리즘 구현
    public static Map<Integer, Integer> bellmanFord(Graph graph, int start) {
        // 거리 초기화
        Map<Integer, Integer> distance = new HashMap<>();
        // 모든 노드에 대한 거리를 MAX_VALUE로 초기화
        for (int i = 0; i < graph.vertices; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(start, 0); // 시작 노드만 0으로 초기화

        // 간선 완화 (노드 수-1)번 반복
        for (int i = 0; i < graph.vertices - 1; i++) {
            for (Edge edge : graph.edges) { // 모든 간선에 대해
                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;

                // 현재 정점까지의 거리가 무한값(갱신되지 않은 거리)이 아니고
                // (현재 정점까지의 거리 + 간선의 가중치) < 도착 정점까지의 거리 이면 갱신
                if (distance.get(u) != Integer.MAX_VALUE && distance.get(u) + weight < distance.get(v)) {
                    //
                    distance.put(v, distance.get(u) + weight);
                }
            }
        }

        // 음수 사이클 검사
        for (Edge edge : graph.edges) {
            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;

            if (distance.get(u) != Integer.MAX_VALUE &&
                distance.get(u) + weight < distance.get(v)) {
                // 음수 사이클 발견
                distance.clear();
                distance.put(-1, -1); // 음수 사이클 표시
                return distance;
            }
        }

        return distance;
    }


    public static void main(String[] args) {
        // 그래프 생성 (정점 5개)
        Graph graph = new Graph(5);

        // 간선 추가
        graph.addEdge(0, 1, 6);  // A->B, 가중치 6
        graph.addEdge(0, 2, 4);  // A->C, 가중치 4
        graph.addEdge(1, 3, 3);  // B->D, 가중치 3
        graph.addEdge(1, 2, -2); // B->C, 가중치 -2
        graph.addEdge(2, 1, 5);  // C->B, 가중치 5
        graph.addEdge(2, 4, 3);  // C->E, 가중치 3
        graph.addEdge(3, 4, 2);  // D->E, 가중치 2
        graph.addEdge(4, 3, -3); // E->D, 가중치 -3

        // 시작 정점 (A = 0)
        int start = 0;

        // 벨만 포드 알고리즘
        Map<Integer, Integer> distances = bellmanFord(graph, start);

        // 결과 출력
        if (distances.containsKey(-1)) {
            System.out.println("그래프에 음수 사이클이 존재합니다");
        } else {
            System.out.println("시작 정점 " + start + "에서부터의 최단 거리:");
            for (int vertex : distances.keySet()) {
                if (vertex != start) { // 시작 정점 제외
                    int distance = distances.get(vertex);
                    if (distance == Integer.MAX_VALUE) {
                        System.out.println("정점 " + vertex + ": 도달 불가능");
                    } else {
                        System.out.println("정점 " + vertex + ": " + distance);
                    }
                }
            }
        }
    }
}